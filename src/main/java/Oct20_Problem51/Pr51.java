package Oct20_Problem51;

import java.util.Arrays;
import java.util.Random;

public class Pr51 {
	private static final Random RND = new Random(System.currentTimeMillis());

	/**
	 * <p>
	 * Given a function that generates perfectly random numbers between 1 and k
	 * (inclusive), where k is an input, write a function that shuffles a deck of
	 * cards represented as an array using only swaps.
	 * 
	 * <p>
	 * It should run in O(N) time.
	 * 
	 * <p>
	 * Hint: Make sure each one of the 52! permutations of the deck is equally
	 * likely.
	 * <p>
	 * Note: This is the "modern" <a href=
	 * "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher–Yates
	 * shuffle</a>
	 * 
	 * @return the shuffled cards in an int[52] array.
	 */
	public static int[] shuffleCards52() {
		int[] cards = new int[52];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = i + 1;
		}

		// shuffle
		for (int i = 0; i < cards.length; i++) {
			// select the ith card
			int card1 = i;
			// select one card from the remaining cards [i+1..52]
			int randomHigh = cards.length - i - 1 + 1;
			System.out.println("rnd: [0.." + (randomHigh - 1) + "]");
			int card2 = i + RND.nextInt(randomHigh);
			swap(cards, card1, card2);
		}

		return cards;
	}

	private static void swap(int[] cards, int card1, int card2) {
		System.out.println("Shuffle: " + card1 + "<->" + card2);
		var tmp = cards[card1];
		cards[card1] = cards[card2];
		cards[card2] = tmp;
	}

	public static void main(String... args) {
		System.out.println(Arrays.toString(shuffleCards52()));
	}
}
