package com.emmanuelnyachoke.csvprocessor;

import com.emmanuelnyachoke.csvprocessor.annotations.CSVColumn;

public class PrimitiveTest {
    @CSVColumn(fieldName = "Total")
    private Integer score;

    public Integer getScore() {
        return score;
    }


    public void setScore(Integer score) {
        this.score = score;
    }
}
