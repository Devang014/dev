package com.yardleydev.app.bankproject.exceptions;

public class InsufficientAmountException extends Exception{

    public  InsufficientAmountException(String message){
        super(message);
    }

}