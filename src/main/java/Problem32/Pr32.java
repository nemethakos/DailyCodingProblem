package Problem32;

/**
 * This problem was asked by Jane Street.
 * 
 * Suppose you are given a table of currency exchange rates, represented as a 2D
 * array. Determine whether there is a possible arbitrage: that is, whether
 * there is some sequence of trades you can make, starting with some amount A of
 * any currency, so that you can end up with some amount greater than A of that
 * currency.
 * 
 * There are no transaction costs and you can trade fractional quantities.
 */
public class Pr32 {

	public static boolean hasPossibleArbitrage(double[][] exchangeRates, String[] currencyNames) {

		return false;
	}

	public static void main(String[] args) {

		System.out.println(hasPossibleArbitrage(new double[][] { //
				{ 1, 0.0036, 0.0031 }, //
				{ 279.09, 1, 0.86 }, //
				{ 323.10, 1.16, 1 }//

		}, new String[] { "HUF", "USD", "EUR" }));

	}

}
