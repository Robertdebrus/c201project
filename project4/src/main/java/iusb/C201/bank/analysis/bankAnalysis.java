package iusb.C201.bank.analysis;

import java.io.IOException;
import java.util.Scanner;

public class bankAnalysis
{
    private String accountDB;
    private String transactionDB;

    public bankAnalysis(String accountDB, String transactionDB)
    {
        this.accountDB = accountDB;
        this.transactionDB = transactionDB;
    }
	
    public void transactionAnalysis() throws IOException
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;
        
        /*
        Your code goes here:
        1. Create an instance of transactionAnalysis and pass parameter transactionDB
        2. Call loadDB() method of the instance
        
        */

        while(done == false)
        {
            System.out.println("\n************************************");
            System.out.println("Transaction Analysis menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. List all transactions");
            System.out.println("2. List transactions of one account");
            System.out.println("9. Return to the parent menu");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();
          
            /*
            Your code goes here:
            modify the following two lines of code 
            If user picks 1, call listAllTransactions() method of the object 
               of transactionAnalysis.
            If user picks 2, call listTransactions() method of the object 
               of transactionAnalysis.
            */
            if(choice == 1) System.out.println("to be done!");
            else if (choice == 2) System.out.println("to be done!");
            else if (choice == 9) done = true;
            else  System.out.println("Please enter a valid input!");
        }
    }
	
    public void accountAnalysis()
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        while(done == false)
        {
            System.out.println("\n************************************");
            System.out.println("Account Analysis menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. Search an account");
            System.out.println("2. List accounts in increasing order of account number");
            System.out.println("3. List accounts in decreasing order of balance");
            System.out.println("9. Return to the parent menu");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if(choice == 1) System.out.println("to be done!");
            else if (choice == 2) System.out.println("to be done!");
            else if (choice == 3) System.out.println("to be done!");
            else if (choice == 9) done = true;
            else  System.out.println("Please enter a valid input!");
        }
    }
}
