package com.cw;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class BigDecimalTest {
    static String name;

    public static void main(String[] args) throws CloneNotSupportedException {
//        List<String> list = new ArrayList<>();
//        ObjectVo test = new ObjectVo();
//        //test.setTotal(test.getAvailiable().divide(new BigDecimal(120).divide(new BigDecimal(50),2,BigDecimal.ROUND_HALF_UP)));
//
//
//        BigDecimal b = new BigDecimal(50).setScale(2,BigDecimal.ROUND_UP).stripTrailingZeros();
//
//        System.out.println(b.toPlainString());
//

        ObjectVo a = new ObjectVo();
        a.setName("a");


        ObjectVo b = (ObjectVo) a.clone();
        b.setName("b");

        b.setTotal(BigDecimal.TEN);
        log.info("a:" + a.toString());
        log.info("a total:" + a.getName().toString());

        log.info("b:" + b.toString());
        log.info("b total:" + (a.getName() == b.getName()));


//        log.info("total:"+test.getTotal());
    }
}
