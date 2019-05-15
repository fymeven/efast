package cn._51even.efast.fastdfs_file_server.controller;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.fastdfs_file_server.service.FastDFSClient;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URLEncoder;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "fastDFS文件接口",tags = "fastDFS")
@RestController
@RequestMapping("/fastDFS")
@Validated
public class FastDFSController {

    @Autowired
    private FastDFSClient fdfsClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile file) throws Exception{
        String url = fdfsClient.uploadFile(file);
        return ResponseResult.successData(url);
    }

    @ApiOperation(value = "文件下载")
    @PostMapping("/download")
    public void  download(String fileUrl, HttpServletResponse response) throws Exception{
        byte[] data = fdfsClient.download(fileUrl);
        response.setCharacterEncoding("UTF-8");
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("."));
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(data, outputStream);
    }

    @ApiOperation(value = "文件缩略图预览")
    @PostMapping("/viewThumbImag")
    public ResponseResult  viewThumbImag(String fileUrl) throws Exception{
        String thumbImagePath = thumbImageConfig.getThumbImagePath(fileUrl);
        return ResponseResult.successData(thumbImagePath);
    }

    @ApiOperation(value = "删除文件")
    @PostMapping("/deleteFile")
    public void  deleteFile(String fileUrl){
       fdfsClient.deleteFile(fileUrl);
    }
}
