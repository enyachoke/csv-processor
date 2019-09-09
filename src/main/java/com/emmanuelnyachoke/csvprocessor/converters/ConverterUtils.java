package com.emmanuelnyachoke.csvprocessor.converters;

import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

import java.util.HashMap;
import java.util.Map;

public class ConverterUtils {
    public static Map converters(){
        Map<Class<?>, Converter<?>> converterMap = new HashMap<Class<?>, Converter<?>>();
        converterMap.put(ArrayConverter.class,ArrayConverter.getSingleton());
        converterMap.put(BooleanConverter.class,BooleanConverter.getSingleton());
        converterMap.put(DateConverter.class,DateConverter.getSingleton());
        converterMap.put(FloatConverter.class,FloatConverter.getSingleton());
        converterMap.put(IntegerConverter.class,IntegerConverter.getSingleton());
        converterMap.put(LongConverter.class,LongConverter.getSingleton());
        converterMap.put(StringConverter.class,StringConverter.getSingleton());
        converterMap.put(VoidConverter.class,VoidConverter.getSingleton());
        return converterMap;
    }

}
