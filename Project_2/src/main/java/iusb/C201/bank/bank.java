package iusb.C201.bank;

import java.util.Scanner;
import java.io.*;
import iusb.C201.bank.analysis.*;
import iusb.C201.bank.management.*;

public class bank
{
    private String accountDB;
    private String transactionDB;

    public bank(String accountDB, String transactionDB)
    {
        this.accountDB = accountDB;
        this.transactionDB = transactionDB;
    }

    public void accountManagement() throws IOException
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;
        
        bankManagement bank = new bankManagement(accountDB);


        while(done == false)
        {
            System.out.println("\n************************************");
            System.out.println("Account Management menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. List all accounts");
            System.out.println("2. Add an account");
            System.out.println("3. Delete an account");
            System.out.println("9. Return to the main menu");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();
            /*
            Your code goes here
            */
            //modify the three lines below
            
            
            if(choice == 1)  bank.listAccounts();
            else if (choice == 2)  bank.addAccount();
            else if (choice == 3) bank.deleteAccount(); 
            
            else if (choice == 9) done = true;
            else  System.out.println("Please enter a valid input!");
        }
    }

    public void conductTransactions()
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        while(done == false)
        {
            System.out.println("\n************************************");
            System.out.println("Transaction menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. Make a deposit");
            System.out.println("2. make a withdrawal");
            System.out.println("9. Return to the main menu");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if(choice == 1) System.out.println("to be done!");
            else if (choice == 2) System.out.println("to be done!");
            else if (choice == 9) done = true;
            else  System.out.println("Please enter a valid input!");
        }
    }

    public void analysis()
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        bankAnalysis BA = new bankAnalysis(accountDB, transactionDB);

        while(done == false)
        {
            System.out.println("\n************************************");
            System.out.println("Account and transaction analysis menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. Transaction analysis");
            System.out.println("2. Account analysis");
            System.out.println("9. Return to the main menu");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if(choice == 1) BA.transactionAnalysis();
            else if (choice == 2) BA.accountAnalysis();
            else if (choice == 9) done = true;
            else  System.out.println("Please enter a valid input!");
        }
    }
}
