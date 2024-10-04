package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Alacarte extends Account
{
    private int pointsRemaining;

    public Alacarte()
    {
        super();
        this.pointsRemaining = 0;
    }

    public Alacarte(BufferedReader br) throws IOException//NEW
    {
        super(br);
        this.pointsRemaining = Integer.parseInt(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException//NEW
    {
        super.save(bw);
        bw.write("" + pointsRemaining + '\n');
    }

    public void buyPoints(int points)
    {
        this.pointsRemaining += points;
    }

    public int getPointsRemaining()
    {
        return this.pointsRemaining;
    }

    @Override
    public String play(Media media)
    {
        int requiredPoints = media.getPoints();
        
        if(pointsRemaining >= requiredPoints)
        {
            pointsRemaining -= requiredPoints;
            return " PLAYING: " + media;
        }
        else
        {
            return "Uh oh! Not enough points! You currently have " + pointsRemaining + " points." + "\nYou need " + requiredPoints + " points.";
        }
    }
}