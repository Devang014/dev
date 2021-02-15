package com.yardleydev.app.bankproject;

import com.yardleydev.app.bankproject.exceptions.DailyLimitExceededException;
import com.yardleydev.app.bankproject.exceptions.InsufficientAmountException;

import java.util.Date;
import java.util.UUID;

public class BankAccount {

    static enum OPERATION {
        WITHDRAW,
        DEPOSIT
    }

    int bankBalance =0;
    String bankAccountID = "";
    Passbook passbook = null;

    public BankAccount(int initialDeposit) {
       bankAccountID= UUID.randomUUID().toString();
       this.bankBalance = initialDeposit;
       this.passbook = new Passbook();
        this.passbook.addEntry(new Date(), OPERATION.DEPOSIT.toString(), initialDeposit);

    }

    public int withDraw(int withDrawAmount) throws InsufficientAmountException{
        if ( bankBalance < withDrawAmount) {
            throw new InsufficientAmountException("balance is low, cannot withdraw " + withDrawAmount);
        }
        else {
            bankBalance = bankBalance -withDrawAmount;
            this.passbook.addEntry(new Date(), OPERATION.WITHDRAW.toString(), withDrawAmount);
        }
        return this.bankBalance;

    }
    public int deposit(int depositAmount) throws DailyLimitExceededException{
         if ( depositAmount > 40_000) {
            throw new DailyLimitExceededException(" Cannot deposit more than 40000 Rupees");
         }
            bankBalance = bankBalance +depositAmount;
        this.passbook.addEntry(new Date(), OPERATION.DEPOSIT.toString(), depositAmount);

        return this.bankBalance;
    }

    public void printPassBookEntries() {
        System.out.println(this.passbook.toString());
    }


}