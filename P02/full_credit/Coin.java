public class Coin
{
	private Denomination denomination;
	private int year;
	
	public Coin(Denomination denomination, int year)
	{
		this.denomination = denomination;
		this.year = year;
	}

	@Override
	public double getValue()
	{
		switch(denomination)
		{
			case PENNY -> 0.01;
			case NICKEL -> 0.05;
			case DIME -> 0.10;
			case QUARTER -> 0.25;
			default -> 0.00;
		}

	}
	
	public int getYear()
	{
		return year;
	}
}