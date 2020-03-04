package iusb.C201.bank.analysis;

import java.util.Scanner;

public class bankAnalysis {

    private String accountDB;
    private String transactionDB;

    public bankAnalysis(String accountDB, String transactionDB) {
        this.accountDB = accountDB;
        this.transactionDB = transactionDB;
    }

    public void transactionAnalysis() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        bankAnalysis BA = new bankAnalysis(accountDB, transactionDB);

        while (done == false) {
            System.out.printf(
                    "\n************************************\n"
                    + "Transaction Analysis menu:\n"
                    + "************************************\n"
                    + "Please choose from the following options:\n"
                    + "1. List all transactions\n"
                    + "2. List transactions of one account\n"
                    + "9. Return to the parent menu\n");

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

    public void accountAnalysis() {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean done = false;

        bankAnalysis BA = new bankAnalysis(accountDB, transactionDB);

        while (done == false) {
            System.out.printf(
                    "\n************************************\n"
                    + "Account Analysis menu:\n"
                    + "************************************\n"
                    + "Please choose from the following options:\n"
                    + "1. Search an account\n"
                    + "2. List accounts in increasing order of account number\n"
                    + "3. List accounts in decreasing order of balance\n"
                    + "9. Return to the parent menu\n");

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

        }

    }
}
