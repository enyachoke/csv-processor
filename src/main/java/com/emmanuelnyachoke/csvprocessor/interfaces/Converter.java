package com.emmanuelnyachoke.csvprocessor.interfaces;


import com.emmanuelnyachoke.csvprocessor.CSVInfo;

public interface Converter<T> {
    public T stringToJava(CSVInfo<T> columnInfo, String value);
    public String javaToString(CSVInfo<T> columnInfo, T fieldValue);
}
