package com.yardleydev.app.bankproject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Passbook {


    static class PassbookEntry {
        private Date entryDate;
        private String operationType;
        private int amount;
        public PassbookEntry( Date entryDate, String operationType, int amount){
            this.entryDate= entryDate;
            this.operationType= operationType;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "PassbookEntry{" +
                    "entryDate=" + entryDate +
                    ", operationType='" + operationType + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    private List<PassbookEntry> passbookEntries;

    public Passbook( ){
        passbookEntries = new ArrayList<>(10);
    }

    public void addEntry ( Date entryDate, String operationType, int amount ) {
        PassbookEntry passbookEntry = new PassbookEntry(entryDate,operationType,amount);
        passbookEntries.add(passbookEntry);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
      for ( PassbookEntry e : passbookEntries ){
         builder.append(e).append("\n");
      }
      return builder.toString();

    }
}
