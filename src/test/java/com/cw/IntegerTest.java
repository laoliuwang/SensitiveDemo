package com.cw;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class IntegerTest {


    public static void main(String[] args) {
        int a =  10;
        log.info("highest val:"+Integer.highestOneBit(a<<1));
        log.info("max val:"+(1<<30));
        log.info("max :"+Integer.MAX_VALUE);
        Map<String,Object> m = new HashMap<String,Object>();
    }
}
