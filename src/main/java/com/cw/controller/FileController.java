package com.cw.controller;


import com.cw.entity.ResponseVO;
import com.cw.utils.FtpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file")
@Slf4j
public class FileController {

    @Autowired
    private FtpUtils ftpUtils;

    @PostMapping("/upload")
    public ResponseVO upload(@RequestParam MultipartFile file) throws IOException {

        boolean flag = ftpUtils.upload("", file.getInputStream(), file.getOriginalFilename());

        ResponseVO vo = new ResponseVO();
        vo.setCode("1");
        return vo;

    }
}
