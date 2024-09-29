package mdi;
import moes.Moes;
import product.Media;
import customer.Student;

public class Main
{
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;

    private void addStudent()
    {
        String name = Menu.getString("Student name? ");
        int id = Menu.getInt("Student ID? ");
        String email = Menu.getString("Student email? ");
        String account = Menu.getString("(a)lacarte or (u)nlimited? ");
        boolean isUnlimited = account.equals("u");
        
        Student student = new Student(name, id, email, isUnlimited);
        moes.addStudent(student);
        
        output = "Added student " + student + "(" + id + email + account + ")";
    }

    private void listStudents()
    {
        output = moes.getStudentList();
    }

    private void addMedia()
    {
        String title = Menu.getString("Title? ");
        String url = Menu.getString("URL? ");
        int points = Menu.getInt("Points? ");
        
        Media media = new Media(title, url);
        moes.addMedia(media);
        
        output = "Added media " + title + "(" + url + points + "points" + ")";
    }

    private void playMedia()
    {
        int studentIndex = Menu.getInt("Student number? ");
        int mediaIndex = Menu.getInt("Media number? ");

        output = moes.playMedia(studentIndex, mediaIndex);
    }

    private void listMedia()
    {
        output = moes.getMediaList();
    }

    private void listAvailablePoints()
    {
        int studentIndex = Menu.getInt("Student number? ");

        output = "Number of points you have: " + moes.getPoints(studentIndex);
    }

    private void buyPoints()
    {
        int studentIndex = Menu.getInt("Student number? ");
        int totalPoints = moes.getPoints(studentIndex);
        int addPoints = Menu.getInt("How many additional points would you like to buy? ");

        if(addPoints < 0)
        {
            output = "No purchasing negative points!";
        }
        else
        {
            output = moes.buyPoints(studentIndex, addPoints);
        }
    }

    public Main()
    {

    }

    public void static main(String[] args)
    {

    }

    private mdi()
    {

    }

    private endApp()
    {

    }
}