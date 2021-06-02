package com.cw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Slf4j
public class SensitivelApplication {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(SensitivelApplication.class, args);


    }
}
