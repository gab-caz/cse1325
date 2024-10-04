package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Unlimited extends Account
{
    public Unlimited()
    {
        super();
    }

    public Unlimited(BufferedReader br) throws IOException//NEW
    {
        super(br);
    }

    public void save(BufferedWriter bw) throws IOException//NEW
    {
        super.save(bw);
    }

    @Override
    public String play(Media media)
    {
        return " PLAYING: " + media.toString();
    }
}