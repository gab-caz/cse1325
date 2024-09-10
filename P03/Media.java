import java.net.URL;//note to self:use this to validate the URL....actually is deprecated
import java.net.MalformedURLException;//note to self:use this to throw an exception if URL is invalid
import java.net.URI;//note to self:oracle recommends

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
            URI uri = new URL(url);
            URL validURL = uri.toURL();
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