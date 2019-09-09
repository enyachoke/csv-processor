package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

public class IntegerConverter implements Converter<Integer> {
    private static final IntegerConverter singleton = new IntegerConverter();

    @Override
    public Integer stringToJava(CSVInfo<Integer> columnInfo, String value) {
        return Integer.parseInt(value);
    }

    @Override
    public String javaToString(CSVInfo<Integer> columnInfo, Integer fieldValue) {
        return String.valueOf(fieldValue);
    }

    public static IntegerConverter getSingleton() {
        return singleton;
    }
}
