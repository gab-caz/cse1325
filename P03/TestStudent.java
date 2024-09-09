public class TestStudent
{
    public static void main(String[] args)
    {
        int failureCount = 0;

        //Test1:verify toString returns correct representation
        String expectedtoString = "Jane Doe (1234567890, jxd@mavs.uta.edu, Account #1)";
        Student student = new Student("Jane Doe", 1234567890, "jxd@mavs.uta.edu");
        if (!expectedtoString.equals(student.toString()))
        {
            System.err.println("Test 1 Failed...toString() method did not return correct representation.");
            failureCount++;
        }


        //Test2:verify that if nonUTA email is used, throw error(3 failure)
        try
        {
            new Student("John Doe", 9087654321, "jd@gmail.com");
            System.err.println("Test 2 Failed...");
            failureCount++;
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Test 2 Failed...");
            failureCount++;
        }
        catch (Exception e)
        {
            System.err.println("Test 2 Failed...");
            failureCount++;
        }


        //Test3:verify media returns "Playing" and media.toString() result
        String expectedMedia = "Playing Title (https://url.com)";
        Media media = new Media("Title", "https://url.com");
        if (!(expectedMedia))
        {
            System.err.println("Test 3 Failed...requesting media returned unexpected results");
            failureCount++;
        }
        
    

        System.exit(failureCount);
    }
}