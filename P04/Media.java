import java.net.URI;
import java.net.URISyntaxException;

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
            new URI(url);
            //this.url = url;  
        }
        catch (URISyntaxException e)
        {
            throw new IllegalArgumentException("Invalid URL: " + url, e);
        }
    }

    @Override
    public String toString()
    {
        return title + " (" + url + ")";
    }
}