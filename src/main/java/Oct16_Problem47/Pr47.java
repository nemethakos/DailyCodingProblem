package Oct16_Problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pr47 {

	/**
	 * <p>
	 * This problem was asked by Facebook.
	 * 
	 * <p>
	 * Given a array of numbers representing the stock prices of a company in
	 * chronological order, write a function that calculates the maximum profit you
	 * could have made from buying and selling that stock once. You must buy before
	 * you can sell it.
	 * 
	 * <p>
	 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could
	 * buy the stock at 5 dollars and sell it at 10 dollars.
	 * 
	 * @param stockPrices the list of stockprices
	 * @return the maxim profit value
	 */
	public static int maximumProfit(List<Integer> stockPrices) {
		
		List<Integer> buyPrices = new ArrayList<>(stockPrices);
		buyPrices.sort((a, b) -> a - b);
		
		List<Integer> sellPrices = new ArrayList<>(stockPrices);
		sellPrices.sort((a, b) -> b - a);

		System.out.println("stock prices chronologically: " + buyPrices);
		System.out.println("buy prices ascending:       " + buyPrices);
		System.out.println("sell prices descending:     " + sellPrices);

		int buyIndex = 0;
		int sellIndex = 0;
		int maxProfit = 0;

		int stockPricesListSize = buyPrices.size();

		for (buyIndex = 0; buyIndex < stockPricesListSize
				&& getProfit(buyPrices, sellPrices, buyIndex, sellIndex) > maxProfit; buyIndex++) {

			for (sellIndex = 0; sellIndex < stockPricesListSize
					&& getProfit(buyPrices, sellPrices, buyIndex, sellIndex) > maxProfit; sellIndex++) {

				int profit = getProfit(buyPrices, sellPrices, buyIndex, sellIndex);

				if ((maxProfit < profit)
						&& isBuyIndexBeforeSellIndex(stockPrices, buyPrices, sellPrices, buyIndex, sellIndex)) {

					maxProfit = profit;

					printResults(stockPrices, buyPrices, sellPrices, buyIndex, sellIndex, maxProfit);

					return maxProfit;

				}
			}
		}

		return 0;
	}

	private static void printResults(List<Integer> stockPrices, List<Integer> buyPrices, List<Integer> sellPrices,
			int buyIndex, int sellIndex, int maxProfit) {
		System.out.println("Max profit: $" + maxProfit);
		System.out.println("buy:  @ $" + buyPrices.get(buyIndex) + "(index: "
				+ getOriginalBuyIndex(stockPrices, buyPrices, buyIndex) + ")");
		System.out.println("sell: @ $" + sellPrices.get(sellIndex) + "(index: "
				+ getOriginalSellIndex(stockPrices, sellPrices, sellIndex) + ")");
	}

	private static boolean isBuyIndexBeforeSellIndex(List<Integer> originalPrices, List<Integer> buyPrices,
			List<Integer> sellPrices, int buyIndex, int sellIndex) {
		return getOriginalBuyIndex(originalPrices, buyPrices, buyIndex) < getOriginalSellIndex(originalPrices,
				sellPrices, sellIndex);
	}

	private static int getOriginalSellIndex(List<Integer> originalPrices, List<Integer> sellPrices, int sellIndex) {
		Integer value = sellPrices.get(sellIndex);
		return originalPrices.indexOf(value);
	}

	private static int getOriginalBuyIndex(List<Integer> originalPrices, List<Integer> buyPrices, int buyIndex) {
		Integer value = buyPrices.get(buyIndex);
		return originalPrices.indexOf(value);
	}

	private static int getProfit(List<Integer> buyPrices, List<Integer> sellPrices, int buyIndex, int sellIndex) {
		return sellPrices.get(sellIndex) - buyPrices.get(buyIndex);
	}

	public static void main(String... args) {
		maximumProfit(Arrays.asList(9, 11, 8, 5, 7, 10));
	}

}
