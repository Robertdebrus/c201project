package iusb.C201.bank.transaction;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class bankTransaction {

    private String accountDB;
    private String transactionDB;
    private ArrayList accounts;

    public bankTransaction(String accountDB, String transactionDB) {
        this.accountDB = accountDB;
        this.transactionDB = transactionDB;
        accounts = new ArrayList<account>();
    }

    public void loadDB() throws IOException {
        /*
        Your code goes here
        (1) Open file accountDB
        (2) Read all records. For each record, create an object
            of account and add it to the ArrayList (accounts)  
        (3) Close the file stream (Scanner)
        
         */

        File file = new File(accountDB);
        Scanner in = new Scanner(file);
        
            while (in.hasNext()) {
                int act = in.nextInt();
                String fn = in.next();
                String ln = in.next();
                double balance = in.nextDouble();
                account a = new account(act, fn, ln, balance);
                accounts.add(a);
            }
          in.close();

 
     
          
    }

    private account searchAccount(int actNum) {
        /*
        Your code goes here
        (1) Search ArrayList (accounts) based on accutunt number (actNum).
            If account is found, return the account.
            If account is not found return null.
        
         */

        for (int i = 0; i < accounts.size(); i++) {
            account a = (account) accounts.get(i);

            if (a.getAccountNumber() == actNum) {
                return a;

            }
        }
        return null;

    }

    public void deposit() {
        /*
        Your code goes here
        (1) Ask the user to enter the account number and the amount to deposit.
        (2) Call method searchAccount().
            If account is found in ArrayList, make the deposit.
            If account is not found in ArrayList, display
            message: "Account not found!"
        
         */
        Scanner in = new Scanner(System.in);
        int tempAcc;
        double amnt;

        System.out.printf("Enter account number%n");
        tempAcc = in.nextInt();
        System.out.printf("Enter ammount you want to deposite%n");
        amnt = in.nextDouble();

        account a = searchAccount(tempAcc);
        if (a != null) {
            a.deposit(amnt);
        } else {
            System.out.print("Account not found!");
        }

    }

    public void withdraw() {
        /*
        Your code goes here
        (1) Ask the user to enter the account number and the amount to withdraw.
        (2) Call method searchAccount().
            If account is not found in ArrayList, display message: "Account not found!"
            If account is found in ArrayList, make the withdrawal.
                If the withdrawal is not successful due to low balance, display
                    message: "no enough balance!" 
        
         */

        Scanner in = new Scanner(System.in);
        int tempAcc;
        double amnt;
        System.out.printf("Enter account number%n");
        tempAcc = in.nextInt();
        System.out.printf("Enter ammount you want to withdraw%n");
        amnt = in.nextInt();
        account a = searchAccount(tempAcc);

        if (a != null) {
            if (!a.withdraw(amnt)) {
                System.out.printf("not enough balance!%n");
            } 
        } else {
            System.out.printf("Account not found!%n");
        }
    }

    public void saveDB() throws IOException {
        /*
        Your code goes here
        (1) Open file accountDB for write operations.
        (2) Read all objects from ArrayList (accounts), for every object,
            retrieve account number, first name, last name, balance, and write 
            them in the file as one record (line)
        (3) Close the file stream (FileWriter)
        
         */
        FileWriter fw = new FileWriter(accountDB, false);
        for (int i = 0; i < accounts.size(); i++) {
            account a = (account) accounts.get(i);
            int act = a.getAccountNumber();
            String fn = a.getFirstname();
            String ln = a.getLastname();
            double balance = a.getBalance();
            fw.write(act + "\t" + fn + "\t" + ln + "\t" + balance + "\n");
        }
        fw.close();
    }
}
