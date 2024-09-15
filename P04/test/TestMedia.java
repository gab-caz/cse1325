package test;
import product.Media;

//import java.net.URI;
//import java.net.URISyntaxException;

public class TestMedia
{
    public static void main(String[] args)
    {
        String title = "Title";
        String url = "https://url.com";
        Media media = new Media(title, url);
        String expected = title + " (" + url + ")";

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
                new Media("Valid", validURL);
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
                new Media("Invalid", invalidURL);
                System.err.println("FAIL: Invalid URL but accepted. " + invalidURL);
            }
            catch (Exception e)
            {
    
            }
        }
    }
}