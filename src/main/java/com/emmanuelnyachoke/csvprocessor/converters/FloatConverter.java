package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

public class FloatConverter implements Converter<Float> {
    private static final FloatConverter singleton = new FloatConverter();
    @Override
    public Float stringToJava(CSVInfo<Float> columnInfo, String value) {
        return Float.valueOf(value);
    }

    @Override
    public String javaToString(CSVInfo<Float> columnInfo, Float fieldValue) {
        return String.valueOf(fieldValue);
    }

    public static FloatConverter getSingleton() {
        return singleton;
    }
}
