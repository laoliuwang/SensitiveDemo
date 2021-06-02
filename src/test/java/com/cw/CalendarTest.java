package com.cw;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class CalendarTest {

    public static String readableFileSize(Long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }




    @Test
    public void test() {

        log.info(readableFileSize(1024*1024*1024*1024L*1022));


        return ;


//        Calendar cal = Calendar.getInstance();
//        log.info("年:" + cal.get(Calendar.YEAR));
//        Date date = new Date();
//
//        log.info("月:" + (cal.get(Calendar.MONTH) + 1));
//
//        log.info("日:" + cal.get(Calendar.DAY_OF_MONTH));
//
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH) + 1;
//
//        String lastPath = year + "" + (month > 9 ? month : "0" + month);
//        log.info(lastPath);


    }
}
