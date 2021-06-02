package com.cw.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

@Service
@Slf4j
public class TestService {
    public volatile static Boolean isSyncing = false;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    public void sync() throws InterruptedException {
        Thread.sleep(50000);

        TestService.isSyncing = false;

        log.info("");
    }

    public void tdsql() throws IOException {
        String fileName = "tdsql模板.xls";
        ServletOutputStream out;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("Content-Type/octet-stream");
        String filePath = getClass().getResource("/static/mysqltemplate.xls").getPath();
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        filePath = URLDecoder.decode(filePath, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        FileInputStream inputSream = new FileInputStream(filePath);
        out = response.getOutputStream();
        int b = 0;
        byte[] buffer = new byte[1024];
        while ((b = inputSream.read(buffer)) != -1) {
            out.write(buffer, 0, b);
        }
        inputSream.close();
        if (out != null) {
            out.flush();
            out.close();
        }
    }
}
