package moes;

import product.Media;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Moes
{
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    public Moes()//NEW
    {

    }
    
    public Moes(BufferedReader br) throws IOException//NEW
    {
        int size = Integer.parseInt(br.readLine());
        library = new ArrayList<>();
        
        for(int i = 0; i < size; i++)
        {
            Media media = new Media(br);
            library.add(media);
        }

        size = Integer.parseInt(br.readLine());
        customers = new ArrayList<>();
        
        for(int i = 0; i < size; i++)
        {
            Student student = new Student(br);
            customers.add(student);
        }
    }

    public void save(BufferedWriter bw) throws IOException//NEW
    {
        bw.write("" + library.size() + '\n');
        
        for(Media media : library)
        {
            media.save(bw);
        }
        
        bw.write("" + customers.size() + '\n');
        
        for(Student student : customers)
        {
            student.save(bw);
        }
    }

    public void addMedia(Media media)
    {
        library.add(media);
    }

    public String getMediaList()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < library.size(); i++)
        {
            Media media = library.get(i);
            sb.append(i).append(") ").append(media.toString()).append("\n");
        }
        return sb.toString();
    }

    public void addStudent(Student student)
    {
        customers.add(student);
    }

    public String getStudentList()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < customers.size(); i++)
        {
            Student student = customers.get(i);
            sb.append(i).append(") ").append(student.toString()).append("\n");
        }
        return sb.toString();
    }

    public int getPoints(int studentIndex)
    {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();
        
        if(account instanceof Alacarte)
        {
            Alacarte alaAccount = (Alacarte) account;
            return alaAccount.getPointsRemaining();
        }
        else if(account instanceof Unlimited)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    public String buyPoints(int studentIndex, int points)
    {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();
        
        if(account instanceof Alacarte)
        {
            Alacarte alaAccount = (Alacarte) account;
            alaAccount.buyPoints(points);
            return "You now have " + alaAccount.getPointsRemaining() + " points!" + 
                   "\n\n---------------------------------------------------------------------------------\n\n";
        }
        else if(account instanceof Unlimited)
        {
            return "You have an unlimited account and need no additional points." +
                   "\n\n---------------------------------------------------------------------------------\n\n";
        }
        else
        {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    public String playMedia(int studentIndex, int mediaIndex)
    {
        Student student = customers.get(studentIndex);
        Media media = library.get(mediaIndex);
        return student.requestMedia(media);
    }
}