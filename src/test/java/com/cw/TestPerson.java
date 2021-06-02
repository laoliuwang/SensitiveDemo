package com.cw;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPerson {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person2 p = new Person2(23, "张三");
        Person2 p1 = (Person2) p.clone();
        log.info("equals:" + (p.getName() == p1.getName()));


    }
}
