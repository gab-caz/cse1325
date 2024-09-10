//note for self: regression test
import java.net.MalformedURLException;

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

        try
        {
            new Media("Valid", validURL);

        }
        catch (RuntimeException e)
        {
            System.err.println("Error: URL is valid but rejected.");
        }

        try
        {
            new Media("Invalid", invalidURL);
            System.err.println("FAIL: URL is invalid but accepted.");
        }
        catch ()
        {
            
        }


    }
}