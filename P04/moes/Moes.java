package moes;
import product.Media;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

import java.util.ArrayList;

public class Moes
{
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    public void addMedia(Media media)
    {
        library.add(media);
    }

    public String getMediaList()//media management
    {
        StringBuilder sb = new StringBuilder();

        for(i = 0; i < library.size(); i++)
        {
            Media media = library.get(i);
            sb.append(i).append(") ").append(media.toString().append("\n"));
        }
        return sb.toString();
    }

    public void addStudent(Student student)//student management
    {
        customers.add(student);
    }

    public String getStudentList()
    {
        StringBuilder sb = new StringBuilder();

        for(i = 0; i < customers.size(); i++)
        {
            Student student = customers.get(i);
            sb.append(i).append(") ").append(student.toString().append("\n"));
        }
        return sb.toString();
    }

    public String getPoints(int studentIndex)
    {
        
        if(account instanceof Alacarte)
        {

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

    }

    public String playMedia(int studentIndex, int mediaIndex)
    {

    }
}