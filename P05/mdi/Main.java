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
        output = moes.getMediaList();
    }

    private void listMedia()
    {

    }

    private void listAvailablePoints()
    {

    }

    private void buyPoints()
    {

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