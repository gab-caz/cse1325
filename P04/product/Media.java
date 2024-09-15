package product;

import java.net.URI;
import java.net.URISyntaxException;

public class Media
{
    private String title;
    private String url;
    private int points;

    public Media(String title, String url, int points)
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

        this.points = points;
    }

    public int getPoints()//write javadoc
    {
        return points;
    }

    @Override
    public String toString()
    {
        return title + " (" + url + points + ")";
    }
}