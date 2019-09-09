package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

public class LongConverter implements Converter<Long> {
    private static final LongConverter singleton = new LongConverter();
    @Override
    public Long stringToJava(CSVInfo<Long> columnInfo, String value) {
        return Long.valueOf(value);
    }

    @Override
    public String javaToString(CSVInfo<Long> columnInfo, Long fieldValue) {
        return String.valueOf(fieldValue);
    }

    public static LongConverter getSingleton() {
        return singleton;
    }
}
