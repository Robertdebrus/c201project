package iusb.C201.bank.analysis;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class transactionAnalysis {

    private String transactionDB;
    private ArrayList transactions;

    public transactionAnalysis(String transactionDB) {
        /*
        Your code goes here
        (1). Assign transactionDB to transactionDB
        (2). Allocate spaces for transactions, which is
             an ArrayList of transactionRecord
        
         */
        this.transactionDB = transactionDB;
        transactions = new ArrayList<transactionRecord>();
    }

    public void loadDB() throws IOException {
        /*
        Your code goes here
        (1) Open file transactionDB
        (2) Read all records. For each record, create an object
            of transactionRecord and add it to the ArrayList (transactions)  
        (3) Close the file stream (Scanner)
        
         */
        File file = new File(transactionDB);
        Scanner in = new Scanner(file);

        while (in.hasNext()) {

            int act = in.nextInt();
            char type = in.next().charAt(0);//test to make sure later.
            double amount = in.nextDouble();
            String time = in.next();
            transactionRecord t = new transactionRecord(act, type, amount, time);
            transactions.add(t);
        }
        in.close();
    }

    public void listTransactions() {
        /*
        Your code goes here
        1. Ask user to enter an account number
        2. Display all the transaction records of that account in the ArrayList
        
         */
    }

    public void listAllTransactions() {
        /*
        Your code goes here
        Display all the transaction records in the ArrayList
        
         */
    }
}
