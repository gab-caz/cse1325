//note for self: regression test

public class TestAccount
{
    public static void main(String[] args)
    {
        Account firstAccountNumber = new Account();

        if(firstAccountNumber.getAccountNumber() != 1)
        {
            System.err.println("FAIL: First account number incorrect. Expected 1 but returned " + firstAccountNumber.getAccountNumber());
        }

        Account secondAccountNumber = new Account();

        if(secondAccountNumber.getAccountNumber() != 2)
        {
            System.err.println("FAIL: Second account number incorrect. Expected 2 but returned " + secondAccountNumber.getAccountNumber());
        }
    }
}