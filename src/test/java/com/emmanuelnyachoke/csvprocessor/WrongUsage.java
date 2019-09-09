package com.emmanuelnyachoke.csvprocessor;

import com.emmanuelnyachoke.csvprocessor.annotations.CSVColumn;

public class WrongUsage {
    @CSVColumn(fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
