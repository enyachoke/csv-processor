package com.emmanuelnyachoke.csvprocessor;

import com.emmanuelnyachoke.csvprocessor.annotations.CSVColumn;

import java.util.Date;

public class WrongDate {
    @CSVColumn(fieldName = "date")
    private Date eventDate;

    public Date getEventDate() {
        return eventDate;
    }


    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
