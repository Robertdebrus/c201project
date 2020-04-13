package iusb.C201.bank.management;

import java.util.Scanner;
import java.io.*;

public class bankManagement
{
    private String accountDB;

    public bankManagement(String accountDB)
    {
        this.accountDB = accountDB;
    }

    private boolean accountExist(int actNum) throws IOException
    {
        File file = new File(accountDB);
        Scanner inFile = new Scanner(file);

        boolean found = false;

        while (inFile.hasNext())
        {
           int act = inFile.nextInt();
           String fn = inFile.next();
           String ln = inFile.next();
           double balance = inFile.nextDouble();

           if(act == actNum) found = true;
        }

        inFile.close();

        return found;
    }
    
    public void listAccounts() throws IOException
    {
        File file = new File(accountDB);
        Scanner inFile = new Scanner(file);

        boolean found = false;

        while (inFile.hasNext())
        {
           int act = inFile.nextInt();
           String fn = inFile.next();
           String ln = inFile.next();
           double balance = inFile.nextDouble();

           System.out.println(act + "\t" + fn + "\t" + ln + "\t" + balance);
        }

        inFile.close();
    }

    public void addAccount() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a new account Number: ");
        int act = input.nextInt();

        if(accountExist(act)== true)
            System.out.println("This account exists.\n");
        else
        {
            System.out.print("Please enter first name: ");
            String fn = input.next();
            System.out.print("Please enter last name: ");
            String ln = input.next();

            FileWriter fw = new FileWriter(accountDB, true);
            fw.write(act + "\t" + fn + "\t" + ln + "\t" + 0 + "\n");
            fw.close();
        }
    }

    public void deleteAccount() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the account Number: ");
        int actNum = input.nextInt();

        File file = new File(accountDB);
        File temp = new File("temp.txt");
        Scanner inFile = new Scanner(file);

        FileWriter outFile = new FileWriter(temp, true);

        boolean found = false;

        while (inFile.hasNext())
        {
           int act = inFile.nextInt();
           String fn = inFile.next();
           String ln = inFile.next();
           double balance = inFile.nextDouble();

           if(act == actNum)
           {
               found = true;
           }
           else
           {
                outFile.write(act + "\t" + fn + "\t" + ln + "\t" + balance + "\n");
           }
        }
	    
        inFile.close();
        outFile.close();

        file.delete();
        temp.renameTo(file);

        if(found==false) System.out.println("Account not found!\n");
        else System.out.println("Account deleted!\n");
    }
}
