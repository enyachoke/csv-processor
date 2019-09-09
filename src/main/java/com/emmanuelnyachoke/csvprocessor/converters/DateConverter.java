package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.CSVInfo;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<Date> {
    private static final DateConverter singleton = new DateConverter();
    @Override
    public Date stringToJava(CSVInfo<Date> columnInfo, String value) {
        SimpleDateFormat format = new SimpleDateFormat(columnInfo.getFormat());
        Date date = null;
        try {
            date = format.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    @Override
    public String javaToString(CSVInfo<Date> columnInfo, Date fieldValue) {
        DateFormat dateFormat = new SimpleDateFormat(columnInfo.getFormat());
        String formattedValue = dateFormat.format(fieldValue);
        return formattedValue;
    }

    public static DateConverter getSingleton() {
        return singleton;
    }
}
