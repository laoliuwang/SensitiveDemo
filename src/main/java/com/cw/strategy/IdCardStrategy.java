package com.cw.strategy;

import com.cw.sensitive.SensitiveInfoUtils;
import com.cw.sensitive.SensitiveType;
import org.springframework.stereotype.Component;

@Component
public class IdCardStrategy implements SensitiveStrategy {
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.ID_CARD;
    }

    @Override
    public String maskData(String str) {
        return SensitiveInfoUtils.idCardNum(str);
    }
}
