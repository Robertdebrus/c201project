import java.util.Scanner;
import java.io.*;
import iusb.C201.bank.*;

public class myProject
{
    public static void main(String[] Args) throws IOException
    {
        String accountDB = "accounts.txt";
        String transactionDB = "transactions.txt";

        // create an account database if it is not there.
        FileWriter myAccounts = new FileWriter(accountDB, true);
        myAccounts.close();

        // create a transaction database if it is not there.
        FileWriter myFile2 = new FileWriter(transactionDB, true);
        myFile2.close();

        bank myBank = new bank(accountDB, transactionDB);    

        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        while(done == false)
        {
            System.out.println("\n************************************");
            System.out.println("Main menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. Account management");
            System.out.println("2. Conduct a transaction");
            System.out.println("3. Account and transaction analysis");
            System.out.println("0. Terminate the program");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if(choice == 1) myBank.accountManagement();
            else if (choice == 2) myBank.conductTransactions();
            else if (choice == 3) myBank.analysis();
            else if (choice == 0) done = true;
            else  System.out.println("Please enter a valid input!");
        }

        System.out.println("Thank you and bye bye!!!");
    }
}