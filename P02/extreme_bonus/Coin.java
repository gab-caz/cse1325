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
        return switch(denomination)
        {
            case PENNY ->
            case NICKEL ->
            case DIME ->
            case QUARTER ->
            default -> 0.0
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