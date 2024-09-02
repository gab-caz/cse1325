public class Coin
{
    private Denomination denomination;
    private int year;
    
    public Coin(Denomination denomination, int year)
    {
        this.denomination = denomination;
        this.year = year;
    }

    public double getValue()
    {
        return denomination.getValue();
    }

    public double getWeight()
    {
        if (denomination == Denomination.PENNY)
        {
            return year 
        }
        else if (denomination == Denomination.NICKEL)
        {
            return 5.000;
        }
        else if (denomination == Denomination.DIME)
        {
            return year 
        }
        else if (denomination == Denomination.QUARTER)
        {
            return year
        }
    }
    
    public int getYear()
    {
        return year;
    }

    @Override
    public String toString()
    {
        return year + " " + denomination.toString();
    }
}