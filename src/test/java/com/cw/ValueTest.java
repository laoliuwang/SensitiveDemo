package com.cw;

public class ValueTest {

    public final static int delayDay = 7;

    public static void main(String[] args) {
        int old = 20*19905;
        int newValue = 230000*delayDay;
        int dailyValue = (old+newValue)/20;
        System.out.println("dailyValue:"+dailyValue);
    }
}
