package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

public class BooleanConverter implements Converter<Boolean> {
    private static final BooleanConverter singleton = new BooleanConverter();
    @Override
    public Boolean stringToJava(CSVInfo<Boolean> columnInfo, String value) {
        return Boolean.parseBoolean(value);
    }

    @Override
    public String javaToString(CSVInfo<Boolean> columnInfo, Boolean fieldValue) {
        return  String.valueOf(fieldValue);
    }

    public static BooleanConverter getSingleton() {
        return singleton;
    }
}
