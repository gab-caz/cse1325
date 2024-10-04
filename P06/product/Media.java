package product;

import java.net.URI;
import java.net.URISyntaxException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Class Media holds the given media title, its URL, and the points needed to play the media.
 *
 * @author      Gabriela Cazares
 * @version     0.2
 * @since       0.2
 */
public class Media
{
    private String title;
    private String url;
    private int points;

    /**
     * Constructor Media sets the instances of title, URL, and points.
     * Also validates the given URL and throws exception if invalid.
     *
     * @param title         The title of the given media.
     * @param url           The url of the given media.
     * @param points        The points needed to play the media.
     * @since               0.2
     */

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

    public Media(BufferedReader br) throws IOException//NEW
    {
        this.title = br.readLine();
        this.url = br.readLine();
        this.points = Integer.parseInt(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException//NEW
    {
        bw.write("" + title   + '\n');
        bw.write("" + url     + '\n');
        bw.write("" + points  + '\n');
    }

    /**
     * Method getPoints will return the amount of points required for the media.
     * 
     * @return      The points required for the media.
     * @since       0.2
     */

    public int getPoints()
    {
        return points;
    }

    /**
     * Overriden Method toString will return the media's title, url, and points in this string format.
     * 
     * @return      The string representation for the media. 
     * @since       0.2 
     */

    @Override
    public String toString()
    {
        return title + " (" + url + ", " + points + " points)";
    }
}