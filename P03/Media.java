import java.net.URL;//note to self:use this to validate the URL
import java.net.MalformedURLException;//note to self:use this to throw an exception if URL is invalid

public class Media
{
    private String title;
    private String url;

    public Media(String title, String url)
    {
        this.title = title;
        this.url = url;

        try
        {
            new URL(url);
            this.url = url;
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException("Invalid URL: " + url, e);
        }
    }

    @Override
    public String toString()
    {
        return title + " (" + url + ")";
    }
}