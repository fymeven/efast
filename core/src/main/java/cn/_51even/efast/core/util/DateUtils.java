package cn._51even.efast.core.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/6/9.
 */
public class DateUtils {

    private static final Logger logger=LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_CHINA_FORMAT = "yyyy年M月d日";

    /**
     * 获取当期日期（yyyy-MM-dd）
     * @return
     */
    public static String getCurrentDate(){
        SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期时间（yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getCurrentDateTime(){
        SimpleDateFormat sdf=new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 获取（yyyy年M月d日）格式日期
     * @param date
     * @return
     */
    public static String getChinaDate(Date date){
        return formatDate(date, DATE_CHINA_FORMAT);
    }

    /**
     * 获取（yyyy年M月d日）格式日期
     * @return
     */
    public static String getChinaDate(){
        return getChinaDate(new Date());
    }

    /**
     * 将Date类型日期转换为String类型（自定义格式）
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDate(Date date,String dateFormat){
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将Date类型日期转换为String类型（yyyy-MM-dd）
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        return formatDate(date,DATE_FORMAT);
    }

    /**
     * 将Date类型日期时间转换为String类型（自定义格式）
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDateTime(Date date,String dateFormat){
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将Date类型日期时间转换为String类型（yyyy-MM-dd HH:mm:ss）
     * @param date
     * @return
     */
    public static String formatDateTime(Date date){
        return formatDateTime(date,DATE_TIME_FORMAT);
    }

    /**
     * 将String类型日期转换为Date类型（自定义格式）
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public static Date parseDate(String dateStr,String dateFormat){
        Date date=null;
        if (StringUtils.isBlank(dateStr)){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        try {
            date=sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("日期转换出错",e);
        }
        return date;
    }

    /**
     * 将String类型日期转换为Date类型（yyyy-MM-dd）
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr){
        return parseDate(dateStr,DATE_FORMAT);
    }

    /**
     * 将String类型日期时间转换为Date类型（自定义格式）
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public static Date parseDateTime(String dateStr,String dateFormat){
        Date date=null;
        if (StringUtils.isBlank(dateStr)){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        try {
            date=sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("日期转换出错",e);
        }
        return date;
    }

    /**
     * 将String类型日期时间转换为Date类型（yyyy-MM-dd HH:mm:ss）
     * @param dateStr
     * @return
     */
    public static Date parseDateTime(String dateStr){
        return parseDate(dateStr,DATE_TIME_FORMAT);
    }

    /**
     * 判断是否闰年
     * @param date
     * @return
     */
    public static boolean isLeapYear(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 以当前时间为准，明天+1 ，昨天-1
     *
     * @param n
     * @return
     */
    public static Date getNDate(int n) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);
        Date nDate = calendar.getTime();
        String dateStr = DateUtils.formatDate(nDate);
        return DateUtils.parseDate(dateStr);
    }
    /**
     * 传入开始时间年月日和结束时间年月日，获取时间区间内的每天的年月日list
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> timeIntervalDay(String startTime,String endTime){
        List<String> list = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(startTime);
            Date d2 = sdf.parse(endTime);
            Calendar c = Calendar.getInstance();
            c.setTime(d1);
            while((c.getTime()).before(d2)) {
                list.add(sdf.format(c.getTime()));
                c.add(Calendar.DATE, 1);
            }
            list.add(sdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 获取开始时间和结束时间的年月日中的每一天的日期和周几
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<Map<String,String>> timeIntervalDayAndWeek(String startTime,String endTime){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        try {
            String[] weekDays = {"0","1","2","3","4","5","6"};
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(startTime);
            Date d2 = sdf.parse(endTime);
            Calendar c = Calendar.getInstance();
            c.setTime(d1);
            while((c.getTime()).before(d2)) {
                Map<String,String> map = new LinkedHashMap<String,String>();
                map.put(sdf.format(c.getTime()), weekDays[c.get(Calendar.DAY_OF_WEEK)-1]);
                list.add(map);
                c.add(Calendar.DATE, 1);
            }
            Map<String,String> map = new LinkedHashMap<String,String>();
            map.put(sdf.format(c.getTime()), weekDays[c.get(Calendar.DAY_OF_WEEK)-1]);
            list.add(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获得指定日期格式的时间戳 eg：2018-09-19 00:00:00
     * @param str
     * @return
     */
    public static Long getCurrentTimeStamp(String str){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            System.out.println(e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }
    public static String getNowTimeStampForUnix(){
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time/1000);
        return nowTimeStamp;
    }
    public static String getTimeStampForUnixByDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp = null;
        try {
            temp = String.valueOf(sdf.parse(str).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
