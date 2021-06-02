package com.cw.strategy;

import com.cw.sensitive.SensitiveInfoUtils;
import com.cw.sensitive.SensitiveType;
import org.springframework.stereotype.Component;

@Component
public class MobilePhoneStrategy implements SensitiveStrategy {
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.MOBILE_PHONE;
    }

    @Override
    public String maskData(String str) {
        return SensitiveInfoUtils.mobile(str);
    }
}
