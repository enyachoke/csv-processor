package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

import java.util.ArrayList;

public class ArrayConverter implements Converter<ArrayList> {
    private static final ArrayConverter singleton = new ArrayConverter();
    @Override
    public ArrayList stringToJava(CSVInfo<ArrayList> columnInfo, String value) {
        return null;
    }

    @Override
    public String javaToString(CSVInfo<ArrayList> columnInfo, ArrayList fieldValue) {
        return null;
    }

    public static ArrayConverter getSingleton() {
        return singleton;
    }
}
