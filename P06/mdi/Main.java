package mdi;

import moes.Moes;
import product.Media;
import customer.Student;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

public class Main
{
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;

    private static Scanner in = new Scanner(System.in);

    private static final String extension = ".moes";
    private static final String magicCookie = "M@g!C c00k!E";
    private static final String fileVersion = "1.0";
    
    private static final String DEFAULT_NAME = "Untitled" + extension;
    private String filename = DEFAULT_NAME;//I wanted my header to correspond with the correct filenames, that's what this is.

    private void newMoes()//8
    {
        this.moes = new Moes();
        filename = DEFAULT_NAME;
        printHeader();
    }

    private void save()//10
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            bw.write(magicCookie);
            bw.newLine();
            bw.write(fileVersion);
            bw.newLine();

            moes.save(bw);
            System.out.println("\nSuccessfully wrote to " + filename);
        }
        catch(Exception e)
        {
            System.err.println("ERROR! Failed to save: " + e);
        }
    }

    private void saveAs()//11
    {
        System.out.println("Current filename: " + filename);
        System.out.print("Enter a new filename to save: ");
        
        String newFileName = in.nextLine();
        
        if(newFileName.isEmpty())
        {
            return;
        }

        if(!newFileName.endsWith(extension))
        {
            newFileName += extension;
        }
        
        filename = newFileName;
        save();
        printHeader();
    }

    private void open()//9
    {
        System.out.println("Current filename: " + filename);
        System.out.print("Open from filename (press Enter to cancel): ");
        
        String givenFile = in.nextLine();

        if(givenFile.isEmpty())
        {
            return;
        }

        if(!givenFile.endsWith(extension))
        {
            givenFile += extension;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(givenFile)))
        {
            String magic = br.readLine();
            String version = br.readLine();

            if(!magicCookie.equals(magic) || !fileVersion.equals(version))
            {
                throw new IOException("ERROR! Invalid file format: Missing magic cookie and file version info.");
            }

            Moes newMoes = new Moes(br);
            moes = newMoes;
            filename = givenFile;
            printHeader();
        }
        catch(IOException e)
        {
            System.err.println("ERROR! Failed to open file: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.err.println("ERROR! Failed to reconstruct Moes object : " + e.getMessage());
        }
    }

    private void addStudent()//7
    {
        String name = Menu.getString("Student name? "); 
        if(name.isEmpty())
        {
            System.out.println("Cancelled add student.");
            return;
        }
        
        Integer id = Menu.getInt("Student ID? ");
        if(id == null)
        {
            System.out.println("Cancelled add student.");
            return;
        }
        
        String email = Menu.getString("Student email? ");
        if(email.isEmpty())
        {
            System.out.println("Cancelled add student.");
            return;
        }
        
        String account = Menu.getString("(a)lacarte or (u)nlimited? ");
        if(account.isEmpty())
        {
            System.out.println("Cancelled add student.");
            return;
        }
        
        boolean isUnlimited = account.equals("u");

        Student student = new Student(name, id, email, isUnlimited);        
        moes.addStudent(student);
        
        output = "\n-----------------------------------------------------------\n\n" + 
                 " ADDED STUDENT: " + student +
                 "\n\n-----------------------------------------------------------\n";
    }

    private void listStudents()//6
    {
        output = "\n-----------------------------------------------------------\n\n" +
                 " >>>STUDENT LIST<<<\n\n" + moes.getStudentList() +
                 "\n-----------------------------------------------------------\n";
    }

    private void addMedia()//5
    {
        String title = Menu.getString("Title? ");
        String url = Menu.getString("URL? ");
        int points = Menu.getInt("Points? ");
        
        Media media = new Media(title, url, points);
        moes.addMedia(media);
        
        output = "\n-----------------------------------------------------------\n\n" + 
                 " ADDED MEDIA: " + title + " (" + url + ", " + points + " points" + ")" +
                 "\n\n-----------------------------------------------------------\n";
    }

    private void playMedia()//1
    {
        listStudents();
        System.out.println(output);
        
        int studentIndex = Menu.getInt("Student number? ");
        
        listMedia();
        System.out.println(output);

        int mediaIndex = Menu.getInt("Media number? ");

        output = "\n-----------------------------------------------------------\n\n" + 
                  moes.playMedia(studentIndex, mediaIndex) +
                  "\n\n-----------------------------------------------------------\n";
    }

    private void listMedia()//2
    {
        output = "\n-----------------------------------------------------------\n\n" +
                 " >>>MEDIA LIST<<<\n\n" + moes.getMediaList() +
                 "\n-----------------------------------------------------------\n";
    }

    private void listAvailablePoints()//3
    {
        listStudents();
        System.out.println(output);
        int studentIndex = Menu.getInt("Student number? ");

        output = "\n-----------------------------------------------------------\n\n" +
                 "You currently have " + moes.getPoints(studentIndex) + " points." +
                 "\n\n-----------------------------------------------------------\n";
    }

    private void buyPoints()//4
    {
        listStudents();
        System.out.println(output);
        int studentIndex = Menu.getInt("Student number? ");

        int totalPoints = moes.getPoints(studentIndex);
        int addPoints = Menu.getInt("How many points would you like to buy? ");

        if(addPoints < 0)
        {
            output = "You can NOT purchase negative points. Try again.";
        }
        else
        {
            output = moes.buyPoints(studentIndex, addPoints);
        }
    }

    public Main()
    {
        this.moes = new Moes();
        this.output = "";
        this.menu = new Menu();
        this.running = true;

        //System.out.println("\nHello!\nYou are currently working under this file: " + filename);

        menu.addMenuItem(new MenuItem("Exit\n",                 () -> endApp()));
        
        menu.addMenuItem(new MenuItem("Play media",             () -> playMedia()));
        menu.addMenuItem(new MenuItem("List media",             () -> listMedia()));
        menu.addMenuItem(new MenuItem("List available points",  () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy points",             () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add media\n",            () -> addMedia()));
        
        menu.addMenuItem(new MenuItem("List all students",      () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add a student\n",          () -> addStudent()));
        
        menu.addMenuItem(new MenuItem("New MOES file",        () -> newMoes()));
        menu.addMenuItem(new MenuItem("Open file",            () -> open()));
        menu.addMenuItem(new MenuItem("Save to file",         () -> save()));
        menu.addMenuItem(new MenuItem("Save as new file",     () -> saveAs()));
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.TitleGraphic();
        main.printHeader();
        main.mdi();
    }

    private void mdi()
    {
        while(running)
        {
            try
            {
                System.out.println(output);
                output = "";
                System.out.println(menu);

                int command = Menu.getInt("Selection? ");

                if(command < 0)
                {
                    continue;
                }
                menu.run(command);
            }
            catch(Exception e)
            {
                System.out.println("Invalid command:\n" + e);
            }
        }
    }

    private void endApp()
    {
        running = false;
    }

    private void TitleGraphic()
    {
        System.out.println("\n___________________________________________________________\n" +
                           "(\\___/)                                            /\\_/\\\n" +
                           "(0 x 0)           <<*---C(^-^)D---*>>             (=o.o=) \n" +
                           "C(\")(\")                                           (\")(\")_/\n" +
                           "~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~\n" +
                           "                     WELCOME TO\n" +
                           "        Mavs Online Entertainment System (MOES)\n\n" +
                           "        Version 0.4\n        Gabriela Cazares\n        2024\n" +
                           "~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~\n");
    }

    private void printHeader()
    {
        System.out.println("\n___________________________________________________________" +
                           "\n\nYou are currently working under this file: " + filename +
                           "\n___________________________________________________________\n");
    }
}