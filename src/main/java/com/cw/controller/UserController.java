package com.cw.controller;

import com.cw.entity.ResponseVO;
import com.cw.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @PostMapping()
    public Object userInfo(@RequestBody User user){

        ResponseVO vo = new ResponseVO();
        return vo;

    }
}
