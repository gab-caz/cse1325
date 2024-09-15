package product;

import java.net.URI;
import java.net.URISyntaxException;

public class Media
{
    private String title;
    private String url;

    public Media(String title, String url)
    {
        this.title = title;

        try
        {
            new URI(url).toURL();  
        }
        catch (Exception e)
        {
            throw new RuntimeException("Invalid URL: " + url, e);
        }

        this.url = url;
    }

    @Override
    public String toString()
    {
        return title + " (" + url + ")";
    }
}