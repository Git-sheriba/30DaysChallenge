// ************************************************************************
// Day 1 Challenge : Program to find the maximum number of cold coffee
// bottles that can be drunk
// ***********************************************************************
// initialColdCoffeeBottles : Given number of cold coffee bottles
// exchangeCount : Number of bottles that can be exchanged for a single cold
// coffee

// 1. Check if given number of cold coffee bottles>exchangeCount
// 2. If it is greater, then divide cold coffee bottles by exchangeCount.
// 3. If remainder exists, add it to the quotient obtained from the step 2 (sum)
// 4. Check the result of step 3 and repeat step 2 when sum>=exchangeCount
// 5. If cold coffee bottles<exchangeCount( in contrary to step 1), exchange is
// not possible.
// ExchngdColdCoffee = initialColdCoffeeBottles;
// *************************************************************************

public class Day1_Challenge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int initialColdCoffeeBottles = 1000;
		int exchangeCount = 4;
		int ExchngdColdCoffee = 0, emptyBottles = 0, TempExchngdColdCoffee = 0;
		int maxCoffeeBottlesToDrink = 0;
		int sum = 0;

		if (initialColdCoffeeBottles >= exchangeCount) {
			ExchngdColdCoffee = initialColdCoffeeBottles / exchangeCount;
			emptyBottles = initialColdCoffeeBottles % exchangeCount;
			sum = ExchngdColdCoffee + emptyBottles;

			while (sum >= exchangeCount) {
				TempExchngdColdCoffee = sum / exchangeCount;
				emptyBottles = sum % exchangeCount;
				sum = TempExchngdColdCoffee + emptyBottles;

				ExchngdColdCoffee = ExchngdColdCoffee + TempExchngdColdCoffee;
			}
			maxCoffeeBottlesToDrink = initialColdCoffeeBottles + ExchngdColdCoffee;
		} else {
			System.out.println("*******************");
			maxCoffeeBottlesToDrink = initialColdCoffeeBottles;
			System.out.println("Exchange can be made only if bottles are greater than or equal to " + exchangeCount);
			System.out.println("*******************");
		}

		System.out.println("The initial number of ColdCoffeeBottles: " + initialColdCoffeeBottles);
		System.out.println("Number of exchange: " + exchangeCount);
		System.out.println("Number of cold coffee bottles that we can drink : " + maxCoffeeBottlesToDrink);
	}

}
