public class Account
{
    private int accountNumber;
    private static int nextAccountNumber;

    public Account()
    {
        this.accountNumber = nextAccountNumber++;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String play(Media media)
    {
        return "Playing " + media.toString();
    }
}