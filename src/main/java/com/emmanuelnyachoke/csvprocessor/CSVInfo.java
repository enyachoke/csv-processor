package com.emmanuelnyachoke.csvprocessor;

import com.emmanuelnyachoke.csvprocessor.annotations.CSVField;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author /u/Philboyd_Studge on 4/1/2017.
 */
public class CSVInfo<T> {
    final int index;
    final String fieldName;
    final CSVTypes type;
    final Field field;
    final boolean quotes;
    final String format;
    final Class<? extends Converter<?>> converter;


    CSVInfo(CSVField annotation, Field field) {
        this.index = annotation.index();
        this.type = annotation.type();
        this.quotes = annotation.quotes();
        this.format = annotation.format();
        this.fieldName = annotation.fieldName();
        this.field = field;
        this.converter = annotation.converterClass();
    }

    static List<CSVInfo> getAnnotatedFieldInfo(Class<?> csvClass) {
        List<CSVInfo> fields = new ArrayList<>();
        Field[] fieldArray = csvClass.getDeclaredFields();
        for (Field each : fieldArray) {
            CSVField annotation = each.getAnnotation(CSVField.class);
            if (annotation != null) {
                each.setAccessible(true);
                fields.add(new CSVInfo(annotation, each));
            }
        }
        return fields;
    }


    public Class<? extends Converter<?>> getConverter() {
        return converter;
    }

    public String getFormat() {
        return format;
    }
}