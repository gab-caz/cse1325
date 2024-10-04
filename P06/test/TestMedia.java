package test;
import product.Media;

public class TestMedia
{
    public static void main(String[] args)
    {
        String title = "Title";
        String url = "https://url.com";
        int points = 80;
        
        Media media = new Media(title, url, points);
        String expected = title + " (" + url + ", " + points + " points)";

        if(!media.toString().equals(expected))
        {
            System.err.println("FAIL: Unexpected media. Expected " + expected + "Actual string returned" + media.toString());
        }

        String[] validURLTest = {"https://youtube.com", "file://media/lib/garp.mp4"};
        String[] invalidURLTest = {"hello.world", "htt://badurl.com", "flub://badurl.com"};

        //VALID URL TEST
        for(String validURL : validURLTest)
        {
            try
            {
                new Media("Valid", validURL, 80);
            }
            catch (Exception e)
            {
                System.err.println("FAIL: Valid URL but unexpected exception. " + validURL);
            }
        }


        //INVALID URL TEST
        for(String invalidURL : invalidURLTest)
        {
            try
            {
                new Media("Invalid", invalidURL, 80);
                System.err.println("FAIL: Invalid URL but accepted. " + invalidURL);
            }
            catch (Exception e)
            {
    
            }
        }
    }
}