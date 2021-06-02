package com.cw.service;

import com.cw.sensitive.SensitiveType;
import com.cw.strategy.SensitiveStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SensitiveStrategyService {
    Map<SensitiveType, SensitiveStrategy> map = new HashMap<>();

    public SensitiveStrategyService(List<SensitiveStrategy> strategyList) {
        strategyList.forEach(sensitiveStrategy -> map.put(sensitiveStrategy.getSensitiveType(), sensitiveStrategy));
    }

    public String generatorSensitive(SensitiveType type, String str) {
        SensitiveStrategy sensitiveStrategy = map.get(type);
        if (sensitiveStrategy != null) {
            return sensitiveStrategy.maskData(str);
        }
        return "";
    }
}
