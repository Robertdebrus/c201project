/*

Team Members: Robert Wallace, Connor Bartlett, Tyler Cline, Salile Malisita 

*/

package iusb.C201.bank.management;

import java.util.Scanner;
import java.io.*;

public class bankManagement {

    private String accountDB;

    public bankManagement(String accountDB) {
        this.accountDB = accountDB;
    }

    private boolean accountExist(int actNum) throws IOException {
        File file = new File(accountDB);
        Scanner inFile = new Scanner(file);

        boolean found = false;

        while (inFile.hasNext()) {
            int act = inFile.nextInt();
            String fn = inFile.next();
            String ln = inFile.next();
            double balance = inFile.nextDouble();

            if (act == actNum) {
                found = true;
            }
        }

        inFile.close();

        return found;
    }

    public void listAccounts() throws IOException {
        /*
        Your code goes here
        1. Open database (file accountDB)
        2. display all the records (accounts) in file
        3. close the stream (Scanner)
         */
        File file = new File(accountDB);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNext()) {
            System.out.println(inFile.nextLine());
        }
        inFile.close();
    }

    public void addAccount() throws IOException {
        /*
        Your code goes here
        1. Ask user to enter a new account number
        2. Call method accountExist to see if this account exists
        3. If this account exits, display message "This account exists"
           If this account does not exist:
            a. Ask user to enter first name, last name
            b. Open database (file accountDB)
            c. Write account number, first name, last name, and balance (0) to file
            d. Close the stream (FileWriter)
         */
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter an account number: ");
        int acctNum = inp.nextInt();
        if (accountExist(acctNum)) {
            System.out.println("This account exists");
        } else {
            System.out.print("Please enter your first name: ");
            String fn = inp.next();
            System.out.print("Please enter your lase name: ");
            String ln = inp.next();

            File file = new File(accountDB);
            Scanner inFile = new Scanner(file);
            FileWriter out = new FileWriter(accountDB, true);
            out.write(acctNum + "\t" + fn + "\t" + ln + "\t" + 0 +"\n");
            
            
            
            out.close();
            inFile.close();
            //inp.close();
        }
    }

    public void deleteAccount() throws IOException {
        /*
        Your code goes here
        1. Ask user to enter an account number
        2. If this account exists, delete it
        3. If this account does not exit, display message "no account found"
        
        note: you should close all input and output file streams after the operation.
         */
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter an account number: ");
        int searchID = inp.nextInt();
        //inp.close();

        File file = new File(accountDB);
        Scanner reader = new Scanner(file);
        FileWriter writer = new FileWriter("temp.txt", true);
        int id;
        boolean found = false;
        while (reader.hasNext()) {
            id = reader.nextInt();
            if (id != searchID) {
                String toWrite = (id + "\t" + reader.next() + "\t" + reader.next()+ "\t" + reader.next() + "\n");
                writer.write(toWrite);
                System.out.print(toWrite);
            }
            if (id == searchID)
                found = true;
            if (reader.hasNext()) reader.nextLine();
        }
        if(!found){
            System.out.println("no account found");
        }
        
        
        writer.close();
        
        reader.close();
        file.delete();
        
        File f1 = new File(accountDB);
        File f2 = new File("temp.txt");
        
        boolean s = f2.renameTo(f1);
        //temp.delete();
        
    }
}
