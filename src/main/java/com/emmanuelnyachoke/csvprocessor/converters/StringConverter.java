package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

public class StringConverter implements Converter<String> {
    private static final StringConverter singleton = new StringConverter();
    @Override
    public String stringToJava(CSVInfo<String> columnInfo, String value) {
        return value;
    }

    @Override
    public String javaToString(CSVInfo<String> columnInfo, String fieldValue) {
        return String.valueOf(fieldValue);
    }

    public static StringConverter getSingleton() {
        return singleton;
    }
}
