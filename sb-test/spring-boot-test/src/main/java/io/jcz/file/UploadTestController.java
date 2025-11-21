package io.jcz.file;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/uploadTest")
public class UploadTestController {

    @GetMapping("/uploadFile")
    public void uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        this.uploadByMachine(request);
    }

    private void uploadByMachine(MultipartHttpServletRequest request) throws IOException {

        List<MultipartFile> fileList = request.getFiles("fileList");
        for (MultipartFile fileItem : fileList) {
            if (fileItem instanceof StandardMultipartHttpServletRequest fileRequest) {
                Iterator<String> fileNames = fileRequest.getFileNames();
                FileUtils.copyInputStreamToFile(fileItem.getInputStream(), new File("D:\\hj-work\\logs\\tmp\\" + 1));
            }

        }
    }

}
