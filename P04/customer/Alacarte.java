package customer;
import product.Media;

public class Alacarte extends Account
{
    private int pointsRemaining;

    public Alacarte()
    {
        this.pointsRemaining = 0;
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
            return "Playing" + media;
        }
        else
        {
            return "Buy more points: Requires " + requiredPoints + "points, you have " + pointsRemaining;
        }
    }
}