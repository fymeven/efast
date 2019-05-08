package cn._51even.efast.core.util;

import cn._51even.efast.core.base.exception.BusinessException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/6/11.
 */
public class ExcelUtils {

    private static final Logger logger=LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * title样式
     * @param hssfWorkbook
     * @return
     */
    public static HSSFCellStyle titleStytle(HSSFWorkbook hssfWorkbook){
        HSSFCellStyle cellStyle=hssfWorkbook.createCellStyle();
        //设置水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        //字体设置
        HSSFFont font = hssfWorkbook.createFont();
        //设置字体格式
        font.setFontName("黑体");
        //设置字体大小
        font.setFontHeightInPoints((short)28);
        //设置粗体
        font.setBold(true);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * header样式
     * @param hssfWorkbook
     * @return
     */
    public static HSSFCellStyle headerStyle(HSSFWorkbook hssfWorkbook){
        HSSFCellStyle cellStyle=hssfWorkbook.createCellStyle();
        //设置水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        //设置背景色
        cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //字体设置
        HSSFFont font = hssfWorkbook.createFont();
        //设置字体格式
        font.setFontName("黑体");
        //设置字体大小
        font.setFontHeightInPoints((short)16);
        cellStyle.setFont(font);
        return cellStyle;
    }

    //内容样式
    public static HSSFCellStyle cellStyle(HSSFWorkbook hssfWorkbook){
        HSSFCellStyle cellStyle=hssfWorkbook.createCellStyle();
        //设置水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        //字体设置
        HSSFFont font = hssfWorkbook.createFont();
        //设置字体格式
        font.setFontName("宋体");
        //设置字体大小
        font.setFontHeightInPoints((short)12);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 导出excel
     * @param response
     * @param exportPath 导出路径
     * @param fileName 导出文件名
     * @param sheetName sheet页名称
     * @param titleName 标题
     * @param headers 表头
     * @param dataList 导出数据List集合
     * @throws Exception
     */
    public static void exportExcel(HttpServletResponse response, String exportPath, String fileName, String sheetName, String titleName, String[] headers, List<String[]> dataList)throws Exception{
        OutputStream outputStream=null;
        HSSFWorkbook hssfWorkbook=null;
        try {
            if (dataList ==null || dataList.isEmpty()){
                throw new BusinessException("导出数据源为空");
            }
            if (exportPath !=null){
                outputStream=new FileOutputStream(exportPath);
            }else {
                response.reset();
                response.setContentType("application/x-msdownload;charset=UTF-8");
                response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8")+".xls");
                outputStream = response.getOutputStream();
            }
            hssfWorkbook= new HSSFWorkbook();
            HSSFSheet sheet = hssfWorkbook.createSheet(sheetName);
            //标题
            HSSFRow titleRow = sheet.createRow(0);
            //设置title行高为40
            titleRow.setHeightInPoints(40);
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,headers.length-1));
            HSSFCell titleCell = titleRow.createCell(0);
            titleCell.setCellStyle(titleStytle(hssfWorkbook));
            titleCell.setCellValue(titleName);
            //header头
            HSSFRow headerRow = sheet.createRow(1);
            //设置header行高为28
            headerRow.setHeightInPoints(28);
            for (int headerCellIndex = 0; headerCellIndex < headers.length; headerCellIndex++) {
                HSSFCell headerCell = headerRow.createCell(headerCellIndex);
                //自动设宽
                sheet.autoSizeColumn(headerCellIndex);
                headerCell.setCellStyle(headerStyle(hssfWorkbook));
                headerCell.setCellValue(headers[headerCellIndex]);
            }
            //内容
            int rowStart=2;
            for (int rowIndex = rowStart; rowIndex < dataList.size()+rowStart; rowIndex++) {
                HSSFRow row = sheet.createRow(rowIndex);
                //设置内容行高为22
                row.setHeightInPoints(22);
                String[] data = dataList.get(rowIndex-rowStart);
                for (int cellIndex = 0; cellIndex < data.length; cellIndex++) {
                    HSSFCell cell = row.createCell(cellIndex);
                    sheet.autoSizeColumn(cellIndex);
                    cell.setCellStyle(cellStyle(hssfWorkbook));
                    cell.setCellValue(data[cellIndex]);
                }
            }
            hssfWorkbook.write(outputStream);
        }catch (Exception e){
            logger.error("导出excel时出错",e);
        }finally {
            hssfWorkbook.close();
            outputStream.close();
        }
    }

    /**
     * 将上传的excel转换成实体集合
     * @param file 上传的文件
     * @param beanClass 要转换的实体，字段要和excel模板相对应
     * @param <T> List集合
     * @return
     */
    public static <T>List<T> getBeanList(MultipartFile file, Class<T> beanClass){
        try {
            List<T> beanList=new ArrayList<>();
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Field[] fields = beanClass.getDeclaredFields();
            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                Sheet sheet = workbook.getSheetAt(sheetIndex);
                int startRow=2;
                for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Map<String,String> dataMap=new HashMap<>();
                    Row row = sheet.getRow(rowIndex);
                    for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                        Cell cell = row.getCell(cellIndex);
                        dataMap.put(fields[cellIndex].getName(),getCellValue(cell));
                    }
                    T bean = beanClass.newInstance();
                    BeanMap beanMap=BeanMap.create(bean);
                    beanMap.putAll(dataMap);
                    beanList.add(bean);
                }
            }
            return beanList;
        }catch (Exception e){
            logger.error("excel转换实体出错",e);
        }
        return null;
    }


    /**
     * 获取合并单元格集合
     * @param sheet
     * @return
     */
    public static List<CellRangeAddress> getMergeRegionList(Sheet sheet){
        List<CellRangeAddress> list=new ArrayList<>();
        int numMergedRegions = sheet.getNumMergedRegions();
        for (int i = 0; i < numMergedRegions; i++) {
            CellRangeAddress cellRangeAddress=sheet.getMergedRegion(i);
            list.add(cellRangeAddress);
        }
        return list;
    }

    /**
     * 判断是否合并单元格
     * @param sheet
     * @param row
     * @param cell
     * @return
     */
    public static boolean isMergedRegion(Sheet sheet,int row,int cell){
        int sheetMergeCount=sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress cellRangeAddress=sheet.getMergedRegion(i);
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            if (row >=firstRow && row <=lastRow){
                if (cell >= firstColumn && cell<=lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @return
     */
    private static boolean isMergedRegion(Sheet sheet,int row){
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i<sheetMergeCount;i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if(row >= firstRow && row <= lastRow){
                return true;
            }
        }
        return false;
    }

    /**
     * 解析excel不同类型的值
     * @param cell
     * @return
     */
    @SuppressWarnings(value = {"unchecked","rawtypes"})
    private static String getCellValue(Cell cell){
        String cellValue="";
        if (cell == null){
            return cellValue;
        }
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                cellValue= cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    cellValue= new SimpleDateFormat("yyyy-MM-dd").format(date);
                }else {
                    double db = cell.getNumericCellValue();
                    BigDecimal bigDecimal = new BigDecimal(db);
                    cellValue = bigDecimal.toPlainString();
                }
                break;
            case Cell.CELL_TYPE_FORMULA:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cellValue=cell.getStringCellValue();
                break;
            default:
                break;
        }
        return cellValue;
    }
}
