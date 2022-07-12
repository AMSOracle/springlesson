package com.mabdullaev.lesson.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MarketError {
    private String message;
    private String stackTrace;
    private Date date;

    public MarketError(String message, String stackTrace) {
        this.message = message;
        this.stackTrace = stackTrace;
        this.date = new Date();
    }
}
