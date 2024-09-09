public class TestStudent
{
    public static void main(String[] args)
    {
        int failureCount = 0;

        //Test1:verify toString returns correct representation
        String expectedtoString = "name(id,email,account#)";
        Student student = new Student();
        if (!expectedtoString.equals(student.toString()))
        {
            System.err.println("Test 1 Failed. toString() not correct representation.");
            failureCount++;
        }


        //Test2:verify that if nonUTA email is used, throw error(3 failure)
        try
        {
            new Student();
            System.err.println("Test 2 Failed. ");
            failureCount++;
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Test 2 Failed. ");
            failureCount++;
        }
        catch (Exception e)
        {
            System.err.println("Test 2 Failed ");
            failureCount++;
        }


        //test3:verify media returns "Playing" and result
        try
        {
            System.err.println("Test 3 Failed. ");
            failureCount++;
        }
        catch (Exception e)
        {
            System.err.println("Test 3 Failed. ");
            failureCount++;         
        }

        System.exit(failureCount);
    }
}