package mdi;

//import moes.Moes;
//import product.Media;
//import customer.Student;

public class Main
{
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;

    private static final String extension = ".moes";
    private static final String magicCookie = "M@g!C c00k!E";
    private static final String fileVersion "1.0";
    private String filename;

    private newMoes()
    {
        this.moes = new Moes();
    }

    private void save()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            bw.write(magicCookie);
            bw.newLine();
            bw.write(fileVersion);
            bw.newLine();

            moes.save(bw);
            System.out.println("Wrote to " + filename);
        }
        catch(Exception e)
        {
            System.err.println("ERROR! Failed to save: " + e);
        }
    }

    private void saveAs()
    {
        System.out.println("Current filename: " + filename);
        System.out.println("Enter a new filename to save: ");
        
        String s = in.nextLine();
        
        if(s.isEmpty())
        {
            return;
        }

        if(!s.endsWith(extension))
        {
            s += extension;
        }
        
        filename = s;
        save();
    }

    private void open()
    {
        System.out.println("Current filename: " + filename);
        System.out.println("Enter a new filename to open: ");
        
        String s = in.nextLine();

        if(s.isEmpty())
        {
            return;
        }

        if(!s.endsWith(extension))
        {
            s += extension;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(s)))
        {
            String magic = br.readLine();
            String version = br.readLine();

            if(!magicCookie.equals(magic) || !fileVersion.equals(version))
            {
                throw new IOException("ERROR! Missing magic cookie and file version info.");
            }

            moes = new Moes(br);
            filename = s;

        }
        catch(Exception e)
        {
            System.err.println("ERROR! Failed to open: " + e);
        }
    }

    private void addStudent()//7
    {
        String name = Menu.getString("Student name? ");
        int id = Menu.getInt("Student ID? ");
        String email = Menu.getString("Student email? ");
        String account = Menu.getString("(a)lacarte or (u)nlimited? ");
        boolean isUnlimited = account.equals("u");

        Student student = new Student(name, id, email, isUnlimited);        
        moes.addStudent(student);
        
        output = "\n---------------------------------------------------------------------------------\n\n" + 
                 " ADDED STUDENT: " + student +
                 "\n\n---------------------------------------------------------------------------------\n";
    }

    private void listStudents()//6
    {
        output = "\n---------------------------------------------------------------------------------\n\n" +
                 " >>>STUDENT LIST<<<\n\n" + moes.getStudentList() +
                 "\n---------------------------------------------------------------------------------\n";
    }

    private void addMedia()//5
    {
        String title = Menu.getString("Title? ");
        String url = Menu.getString("URL? ");
        int points = Menu.getInt("Points? ");
        
        Media media = new Media(title, url, points);
        moes.addMedia(media);
        
        output = "\n---------------------------------------------------------------------------------\n\n" + 
                 " ADDED MEDIA: " + title + " (" + url + ", " + points + " points" + ")" +
                 "\n\n---------------------------------------------------------------------------------\n";
    }

    private void playMedia()//1
    {
        listStudents();
        System.out.println(output);
        
        int studentIndex = Menu.getInt("Student number? ");
        
        listMedia();
        System.out.println(output);

        int mediaIndex = Menu.getInt("Media number? ");

        output = "\n---------------------------------------------------------------------------------\n\n" + 
                  moes.playMedia(studentIndex, mediaIndex) +
                  "\n\n---------------------------------------------------------------------------------\n";
    }

    private void listMedia()//2
    {
        output = "\n---------------------------------------------------------------------------------\n\n" +
                 " >>>MEDIA LIST<<<\n\n" + moes.getMediaList() +
                 "\n---------------------------------------------------------------------------------\n";
    }

    private void listAvailablePoints()//3
    {
        listStudents();
        System.out.println(output);
        int studentIndex = Menu.getInt("Student number? ");

        output = "\n---------------------------------------------------------------------------------\n\n" +
                 "You currently have " + moes.getPoints(studentIndex) + " points." +
                 "\n\n---------------------------------------------------------------------------------\n";
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

        menu.addMenuItem(new MenuItem("Exit\n",                 () -> endApp()));
        menu.addMenuItem(new MenuItem("Play media",             () -> playMedia()));
        menu.addMenuItem(new MenuItem("List media",             () -> listMedia()));
        menu.addMenuItem(new MenuItem("List available points",  () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy points",             () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add media\n",            () -> addMedia()));
        menu.addMenuItem(new MenuItem("List all students",      () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add a student",          () -> addStudent()));
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.TitleGraphic();
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
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    private void endApp()
    {
        running = false;
    }

    private void TitleGraphic()
    {
        System.out.println("\n\n(\\___/)                                            /\\_/\\\n" +
                           "(0 x 0)           <<*---C(^-^)D---*>>             (=o.o=) \n" +
                           "C(\")(\")                                           (\")(\")_/\n" +
                           "~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~,~~\n" +
                           "                     WELCOME TO\n" +
                           "        Mavs Online Entertainment System (MOES)\n\n" +
                           "        Version 0.3\n        Gabriela Cazares\n        2024\n" +
                           "~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~.~~\n");
    }
}