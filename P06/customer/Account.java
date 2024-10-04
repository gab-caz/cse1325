package customer;

import product.Media;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Account
{
    private int accountNumber;
    private static int nextAccountNumber = 1;

    public Account()
    {
        this.accountNumber = nextAccountNumber++;
    }

    public Account(BufferedReader br) throws IOException//NEW
    {
        this.accountNumber = Integer.parseInt(br.readLine());
        nextAccountNumber = Integer.parseInt(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException//NEW
    {
        bw.write("" + accountNumber     + '\n');
        bw.write("" + nextAccountNumber + '\n');
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public abstract String play(Media media);
}