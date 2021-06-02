package com.cw.entity;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person implements Runnable {
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void run() {
        int a = 0;
        for (int i = 0; i < 10000; i++) {
            a += i;
        }
        log.info(name);
    }

}
