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
        System.out.printf("Enter an account number%n");
        Scanner input = new Scanner(System.in);
        int actN = input.nextInt();
        for (int i=0;i<transactions.size();i++) {
            transactionRecord t = (transactionRecord)transactions.get(i);
            if (t.getActnum() == actN) {
                System.out.printf("%d\t%s\t%.2f\t%s%n", t.getActnum(), t.getType(), t.getAmount(), t.getTime());
            }
        }
        //end
    }

    public void listAllTransactions() {
        /*
        Your code goes here
        Display all the transaction records in the ArrayList

         */

        for (Object transaction : transactions) {
            transactionRecord t = (transactionRecord) transaction;

            System.out.printf("%d\t%s\t%.2f\t%s%n", t.getActnum(), t.getType(), t.getAmount(), t.getTime());

        }
        //end 
    }
}
