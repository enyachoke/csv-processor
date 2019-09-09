package com.emmanuelnyachoke.csvprocessor.annotations;


import com.emmanuelnyachoke.csvprocessor.CSVTypes;
import com.emmanuelnyachoke.csvprocessor.converters.VoidConverter;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CSVField {
    int index();
    CSVTypes type() default CSVTypes.STRING;
    public Class<? extends Converter<?>> converterClass() default VoidConverter.class;
    boolean quotes() default false;
    String format() default "";
    String fieldName();
}
