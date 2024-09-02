public class Purse
{
    public static void main(String[] args)
    {
        Coin[] money = { new Coin(Denomination.PENNY, 1904),
                         new Coin(Denomination.NICKEL, 1945),
                         new Coin(Denomination.DIME, 1996),
                         new Coin(Denomination.QUARTER, 2006),
                         new Coin(Denomination.PENNY, 1975),
                         new Coin(Denomination.NICKEL, 1981),
                         new Coin(Denomination.DIME, 1998),
                         new Coin(Denomination.QUARTER, 2003)
                       };
        
        double total = 0;
        double weight = 0;
        int earliestDate = money[0].getYear();
        int latestDate = money[0].getYear();

        for (Coin coin : money)
        {
            if (coin.getYear() < earliestDate)
            {
                earliestDate = coin.getYear();
            }
            
            if (coin.getYear() > latestDate)
            {
                latestDate = coin.getYear();
            }
        }

        for (int inOrder = earliestDate; inOrder <= latestDate; inOrder++)
        {
            for (Coin coin : money)
            {
                if (coin.getYear() == inOrder)
                {
                    System.out.println(coin);
                    total += coin.getValue();
                    weight += coin.getWeight();
                }
            }
        }

        System.out.printf("\nYou have a total of $%.2f", total);
        System.out.printf("\nThe coins span the years " + earliestDate + "-" + latestDate);
        System.out.printf("\nYour coins weigh %f grams", weight);
    }
}