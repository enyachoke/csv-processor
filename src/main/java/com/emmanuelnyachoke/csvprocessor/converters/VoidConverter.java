package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

public class VoidConverter implements Converter<Void> {
    private static final VoidConverter singleton = new VoidConverter();
    @Override
    public Void stringToJava(CSVInfo<Void> columnInfo, String value) {
        return null;
    }

    @Override
    public String javaToString(CSVInfo<Void> columnInfo, Void fieldValue) {
        return null;
    }

    public static VoidConverter getSingleton() {
        return singleton;
    }
}
