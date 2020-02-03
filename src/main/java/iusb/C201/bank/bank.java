package iusb.C201.bank;

import java.util.Scanner;
import iusb.C201.bank.analysis.*;

public class bank {

    private String accountDB;
    private String transactionDB;

    public bank(String accountDB, String transactionDB) {
        this.accountDB = accountDB;
        this.transactionDB = transactionDB;
    }

    public void accountManagement() {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        bankAnalysis BA = new bankAnalysis(accountDB, transactionDB);

        while (done == false) {
            System.out.printf(
                    "\n************************************\n"
                    + "Account Management menu:\n"
                    + "************************************\n"
                    + "Please choose from the following options:\n"
                    + "1. List all accounts\n"
                    + "2. Add an account\n"
                    + "3. Delete an account\n"
                    + "9. Return to the main menu\n");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if (choice == 1) {

                System.out.println("To be done!");

            } else if (choice == 2) {

                System.out.println("To be done!");

            } else if (choice == 3) {

                System.out.println("To be done!");

            } else if (choice == 9) {
                done = true;
            } else {
                System.out.println("Please enter a valid input!");
            }

            /*Your choice:
			
			If user picks (1), (2) or (3) show message "to be done!"
			If user picks (9) terminate the while loop
			If user picks other choices, show message "Please enter a valid input!"
             */
        }
    }

    public void conductTransactions() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        bankAnalysis BA = new bankAnalysis(accountDB, transactionDB);

        while (done == false) {
            System.out.printf(
                    "\n************************************\n"
                    + "Conduct transaction menu:\n"
                    + "************************************\n"
                    + "Please choose from the following options:\n"
                    + "1. Make a deposit\n"
                    + "2. Make a withdrawal\n"
                    + "9. Return to the main menu\n");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if (choice == 1) {

                System.out.println("To be done!");

            } else if (choice == 2) {

                System.out.println("To be done!");

            } else if (choice == 9) {
                done = true;
            } else {
                System.out.println("Please enter a valid input!");
            }
            
        }
    }

    public void analysis() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        bankAnalysis BA = new bankAnalysis(accountDB, transactionDB);

        while (done == false) {
            System.out.println("\n************************************");
            System.out.println("Account and transaction analysis menu:");
            System.out.println("************************************");
            System.out.println("Please choose from the following options:");
            System.out.println("1. Transaction analysis");
            System.out.println("2. Account analysis");
            System.out.println("9. Return to the main menu");

            System.out.print("\nYour choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                BA.transactionAnalysis();
            } else if (choice == 2) {
                BA.accountAnalysis();
            } else if (choice == 9) {
                done = true;
            } else {
                System.out.println("Please enter a valid input!");
            }
        }
    }
}
