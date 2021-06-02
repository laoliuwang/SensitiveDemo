package com.cw.sensitive;


import org.springframework.util.StringUtils;

public class SensitiveInfoUtils {
    public static String idCardNum(final String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        return num.substring(0, 3).concat("******").concat(num.substring(num.length() - 3, num.length()));
    }

    public static String mobile(String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        return num.substring(0, 3).concat("******").concat(num.substring(num.length() - 3, num.length()));
    }
}
