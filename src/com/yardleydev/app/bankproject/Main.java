package com.yardleydev.app.bankproject;

import com.yardleydev.app.bankproject.exceptions.DailyLimitExceededException;
import com.yardleydev.app.bankproject.exceptions.InsufficientAmountException;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount(10_000);
        try {
            System.out.println("balance after " + bankAccount.deposit(30_000));
            System.out.println("balance after " + bankAccount.withDraw(5000));
            System.out.println("balance after " + bankAccount.withDraw(10_000));
        } catch ( InsufficientAmountException | DailyLimitExceededException ie) {
            System.out.println("Program failed to complete ");
            ie.printStackTrace();
        }
       bankAccount.printPassBookEntries();

    }
}
