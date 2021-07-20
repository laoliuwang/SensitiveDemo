package com.cw.controller;


import com.cw.entity.UserInfo;
import com.cw.service.ExportService;
import com.cw.service.TestService;
import com.cw.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    private ExportService exportService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("/sensitive")
    public Object sensitive() throws IOException, InterruptedException {
        String ipString = CommonUtils.getIpAddr(request);
        log.info("ip:"+ipString);
        return UserInfo.getUserInfo();
    }

    @GetMapping("/export")
    public Object export() throws IOException, InterruptedException {



        this.exportService.testExport();
        return null;
    }
}
