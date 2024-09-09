//note for self: regression test

public class TestStudent
{
    public static void main(String[] args)
    {
        int failureCount = 0;

        //Test1
        String name1 = "Jane Doe";
        int id1 = 1001762359;
        String email1 = "jxd@mavs.uta.edu";

        //Test2
        String name2 = "John Doe";
        int id2 = 1001369223;
        String email2 = "john.doe@gmail.com";

        //Test3
        String name3 = "John Smith";
        int id3 = 1001772245;
        String email3 = "jxs@uta.edu";


        //Test1:verify toString returns correct representation
        Student studentTest1 = new Student(name1, id1, email1);
        String expectedtoString = name1 + " (" + id1 + ", " + email1 + ", Account #" + studentTest1.getAccount().getAccountNumber() + ")";
        if (!studentTest1.toString().equals(expectedtoString))
        {
            System.err.println("Test 1 Failed...toString() method did not return correct representation: " + studentTest1.toString());
            failureCount++;
        }


        //Test2:verify that if nonUTA email is used, throw error(3 failure)
        try
        {
            Student studentTest2 = new Student(name2, id2, email2);
            System.err.println("Test 2 Failed...IllegalArgumentException was not thrown for incorrect email.");
            failureCount++;
        }
        catch (IllegalArgumentException e)
        {
            if(!e.getMessage().equals("Non-UTA email address: john.doe@gmail.com"))
            {
                System.err.println("Test 2 Failed...Unexpected exception message: " + e.getMessage());
                failureCount++;
            }
        }
        catch (Exception e)
        {
            System.err.println("Test 2 Failed...Unexpected exception: " + e);
            failureCount++;
        }


        //Test3:verify media returns "Playing" and media.toString() result
        Student studentTest3 = new Student (name3, id3, email3);
        String expectedMedia = "Playing Title (https://url.com)";
        Media media = new Media("Title", "https://url.com");
        String mediaResult = studentTest3.requestMedia(media);
        if (!mediaResult.equals(expectedMedia))
        {
            System.err.println("Test 3 Failed...requesting media returned unexpected results: " + mediaResult);
            failureCount++;
        }


        System.exit(failureCount);
    }
}