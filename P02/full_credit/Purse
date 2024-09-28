public class Purse
{
	public static void main(String[] args)
	{
		Coin[8] Money = { new Coin(Denomination.PENNY, 1904),
						  new Coin(Denomination.NICKEL, 1945),
						  new Coin(Denomination.DIME, 1996),
						  new Coin(Denomination.QUARTER, 2006),
						  new Coin(Denomination.PENNY, 1975),
						  new Coin(Denomination.NICKEL, 1981),
						  new Coin(Denomination.DIME, 1998),
						  new Coin(Denomination.QUARTER, 2003) };
		
		for (Coin coin : Money)
		{
			total += coin.getValue();
			
			if (coin.getYear() < earliestDate)
			{
				earliestDate = coin.getYear();
			}
			
			if (coin.getYear() > latestYear)
			{
				latestYear = coin.getYear();
			}
		}

		System.out.println("Your wallet has $" + total);
		System.out.println("The coins span the years " + earliestDate + "-" + latestDate);
	}
}