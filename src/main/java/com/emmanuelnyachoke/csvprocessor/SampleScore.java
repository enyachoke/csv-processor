package com.emmanuelnyachoke.csvprocessor;

import com.emmanuelnyachoke.csvprocessor.annotations.CSVField;
import com.emmanuelnyachoke.csvprocessor.annotations.CSVHeader;
import com.emmanuelnyachoke.csvprocessor.converters.BooleanConverter;
import com.emmanuelnyachoke.csvprocessor.converters.DateConverter;
import com.emmanuelnyachoke.csvprocessor.converters.IntegerConverter;
import com.emmanuelnyachoke.csvprocessor.converters.StringConverter;

import java.util.Date;

@CSVHeader(has_header = true)
public class SampleScore {
    @CSVField(index=0,fieldName ="StudentName", type=CSVTypes.STRING ,quotes=true , converterClass = StringConverter.class)
    private String studentName;

    @CSVField(index=1,fieldName ="Total", type=CSVTypes.INTEGER ,converterClass = IntegerConverter.class)
    private Integer totalScore;

    @CSVField(index=2,fieldName ="TestDate", type=CSVTypes.DATE, format = "yyyy-MM-dd" , quotes=true , converterClass = DateConverter.class)
    private Date testDate;

    @CSVField(index=3, fieldName ="Passed" ,  type=CSVTypes.BOOL, quotes=true , converterClass = BooleanConverter.class)
    private Boolean passed;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }
}
