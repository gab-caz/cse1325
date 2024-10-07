package mdi;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    private ArrayList<MenuItem> items = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public void addMenuItem(MenuItem item)
    {
        items.add(item);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < items.size(); ++i)
        {
            sb.append(" " + i + "] " + items.get(i) + "\n");
        }
        return sb.toString();
    }

    public void run(int itemNumber)
    {
        items.get(itemNumber).run();
    }

    public static String getString(String prompt, String cancelInput, String defaultInput)
    {
        String s = null;
        while(true)
        {
            try
            {
                System.out.print(prompt);
                s = in.nextLine().trim();
                if(s.isEmpty() && defaultInput != null)
                {
                    s = defaultInput;
                }
                break;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input! Try again.");
            }
        }
        
        if(cancelInput != null && s.equals(cancelInput))
        {
            s = null; 
        }
        return s;
    }

    public static String getString(String prompt)
    {
        return getString(prompt, null, null);
    }

    public static Integer getInt(String prompt, String cancelInput, String defaultInput)
    {
        Integer i = null;
        while(true)
        {
            try 
            {
                String s = getString(prompt, cancelInput, defaultInput);
                if(s == null)
                {
                    return -1;
                }
                if(!s.isEmpty())
                {
                    i = Integer.parseInt(s);
                }
                break;
            }
            catch(Exception e)
            {
                System.err.println("\nInvalid input! Try again.\n");
            }
        }
        return i;
    }

    public static Integer getInt(String prompt)
    {
        return getInt(prompt, null, null);
    }
}