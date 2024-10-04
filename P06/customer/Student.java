package customer;

import product.Media;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Student
{
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name, int id, String email, boolean unlimited)
    {
        if(!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu"))
        {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }

        this.name = name;
        this.id = id;
        this.email = email;
        
        if(unlimited)
        {
            this.account = new Unlimited();
        }
        else
        {
            this.account = new Alacarte();
        }
    }

    public Student(BufferedReader br) throws IOException//NEW
    {
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();
        
        String accountClassName = br.readLine();
        
        switch(accountClassName)
        {
            case "customer.Alacarte" -> this.account = new Alacarte(br);
            case "customer.Unlimited" -> this.account = new Unlimited(br);
            default -> throw new IllegalArgumentException("Unknown account type. Try again.");
        }    
    }

    public void save(BufferedWriter bw) throws IOException//NEW
    {
        bw.write("" + name  + '\n');
        bw.write("" + id    + '\n');
        bw.write("" + email + '\n');

        bw.write(account.getClass().getName() + '\n');
        account.save(bw);
    }

    public String requestMedia(Media media)
    {
        return account.play(media);
    }

    public Account getAccount()
    {
        return this.account;
    }

    @Override
    public String toString()
    {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
    }
}