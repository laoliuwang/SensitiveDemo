package com.cw.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ExportService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    public void testExport() {
        try {
            String fileName = "tdsql.xls";
            ServletOutputStream out;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("content-type/octet-stream");
            String filePath = getClass().getResource("/static/tdsqltemplate.xls").getPath();
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.contains("NSIE") || userAgent.contains("Trident")) {

                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");


            } else {

                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

            }

            filePath = URLDecoder.decode(filePath, "UTF-8");

            log.info("filePath:"+filePath);
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
             //InputStream inputStream2 = this.getClass().getResourceAsStream("/static/tdsqltemplate.xls");

            ClassPathResource r = new ClassPathResource("/static/tdsqltemplate.xls");
            InputStream inputStream = r.getInputStream();
            //FileInputStream inputStream = new FileInputStream(filePath);

            out = response.getOutputStream();
            int b=0;
            byte[] buffer = new byte[1024];
            while ((b=inputStream.read(buffer))!=-1){
                out.write(buffer,0,b);
            }
            inputStream.close();
            if(out!=null){
                out.flush();
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
