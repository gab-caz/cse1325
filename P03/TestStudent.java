public class TestStudent
{
    public static void main(String[] args)
    {
        try//Test1:verify toString returns correct representation 
        {
            String expected = "Name(id,email,account number)";

        }
        catch (Exception e)
        {
            System.err.println("Test 1 Failed.");

        }


        try//Test2:verify that if nonUTA email is used, throw error(3 failure)
        {

        }
        catch (Exception e)
        {
            System.err.println("Test 2 Failed.");
            
        }


        try//test3:verify media returns "Playing" and result
        {
            String expected = "Playing " + media.toString();

        }
        catch (Exception e)
        {
            System.err.println("Test 3 Failed.");
            
        }
    }
}