package Aug31;

/**
 * This problem was recently asked by Google.
 * 
 * Given a list of numbers and a number k, return whether any two numbers from
 * the list add up to k.
 * 
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is
 * 17.
 * 
 * Bonus: Can you do this in one pass?
 */
public class Pr1 {

	public static boolean arrayHasAPairWhoseSumIs(int number, int[] array) {
		boolean found = false;

		foundTheNumber: //

		for (var i = 0; i <= array.length - 2; i++) {
			for (var j = i + 1; j < array.length; j++) {
				found = array[i] + array[j] == number;
				if (found) {
					System.out.format("i=%d, j=%d, array[i]=%d, array[j]=%d, sum=%d", i, j, array[i], array[j], number);
					break foundTheNumber;
				}
			}

		}

		return found;
	}

	public static boolean arrayHasAPairWhoseSumIsOneLoop(int number, int[] array) {
		boolean found = false;

		int i = 0;
		int j = i + 1;
		while (!found && i < array.length - 1) {
			found = array[i] + array[j] == number;
			System.out.format("found=%b, i=%d, j=%d, array[i]=%d, array[j]=%d, sum=%d%n", found, i, j, array[i],
					array[j], number);
			if (!found) {
				j++;
				if (j == array.length) {
					i++;
					j = i + 1;
				}
			}
		}

		return found;
	}

	public static void main(String... args) {

		// arrayHasAPairWhoseSumIs(17, new int[] { 10, 15, 3, 7 });
		arrayHasAPairWhoseSumIsOneLoop(171, new int[] { 10, 15, 3, 7 });

	}

}
