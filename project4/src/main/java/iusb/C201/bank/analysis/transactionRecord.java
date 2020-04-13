package iusb.C201.bank.analysis;

public class transactionRecord
{
    private int actNumber;
    private char type; //'D' represents deposit; 'W' represents withdrawl 
    private double amount;
    private String time;

    public transactionRecord(int act, char type, double amount, String time)
    {
        /*
        Your code goes here:
        Constructor: assign these four parameters to the four
                     class attributes 
        */
        this.actNumber=act;
        this.type=type;
        this.amount = amount;
        this.time=time;
        
    }

    public int getActnum()
    {
        /*
        Your code goes here: return account number
        */
        return this.actNumber;
    }

    public char getType()
    {
        /*
        Your code goes here: return transaction type
        */
        return this.type;
    }

    public double getAmount()
    {
        /*
        Your code goes here: return transaction amount
        */
        return this.amount;
    }

    public String getTime()
    {
        /*
        Your code goes here: return transaction time
        */
        return this.time;
    }
}
