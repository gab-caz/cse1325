package test;
import customer.Account;
import customer.Unlimited;

public class TestAccount
{
    public static void main(String[] args)
    {
        int accountNumber = 2;
        int expectedAccountNumber = 1;

        for (int i = 0; i < accountNumber; i++)
        {
            Account account = new Unlimited();

            if(account.getAccountNumber() != expectedAccountNumber)
            {
                System.err.println("FAIL: Account number incorrect: " + account.getAccountNumber() + "Expected " + expectedAccountNumber);
            }

            expectedAccountNumber++;
        }
    }
}