package com.yardleydev.app.bankproject.exceptions;

public class DailyLimitExceededException extends  Exception  {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}
