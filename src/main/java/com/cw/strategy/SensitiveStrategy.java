package com.cw.strategy;

import com.cw.sensitive.SensitiveType;

public interface SensitiveStrategy {
    SensitiveType getSensitiveType();

    String maskData(String str);
}
