package com.cw.config;

import com.cw.entity.Gender;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class GenderConvert implements Converter<String, Gender> {

    @Override
    public Gender convert(String s) {
        return null;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Gender, ? extends U> after) {
        return null;
    }
}
