package Oct4;

import java.util.Arrays;

/**
 * <p>
 * <em>This is a version of the
 * <a href="https://en.wikipedia.org/wiki/Dutch_national_flag_problem">Dutch
 * National Flag problem</a>
 * 
 * <p>
 * This problem was asked by Google.
 * 
 * <p>
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the
 * values of the array so that all the Rs come first, the Gs come second, and
 * the Bs come last. You can only swap elements of the array.
 * 
 * <p>
 * Do this in linear time and in-place.
 * 
 * <p>
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should
 * become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 *
 */
public class Pr35 {

	private static final boolean SWAP_WITHOUT_TEMP_VARIABLE = true;

	/**
	 * Segregates the values of the array {@code arr} to heva the following order:
	 * 'R', 'G', 'B'. The array is modified in-place in linear time: O(n) < O(2n) =>
	 * O(n).
	 * 
	 * @param arr the array containsing only 'R', 'G' or 'B' characters.
	 */
	void rgb(char[] arr) {
		var p = 0;
		var q = 0;
		var chrList = Arrays.asList('R', 'G');
		for (var c : chrList) {
			q = p + 1;
			while (q < arr.length) {
				if (arr[p] == c) {
					p++;
				} else if (arr[p] != c && arr[q] == c) {
					swap(arr, p, q);
					p++;
				}
				q++;
			}
		}
	}

	/**
	 * Swaps {@code arr[q]} with {@code arr[p]}
	 * <li><em>with</em> temp variable if {@link #SWAP_WITHOUT_TEMP_VARIABLE} equals
	 * to {@code true},
	 * <li><em>without</em> temp variable when {@link #SWAP_WITHOUT_TEMP_VARIABLE}
	 * equals to {@code false}.
	 * 
	 * @param arr the array of characters
	 * @param p   first array index to swap
	 * @param q   second array index to swap
	 */
	private void swap(char[] arr, int p, int q) {
		if (SWAP_WITHOUT_TEMP_VARIABLE) {
			swapWithoutTempVar(arr, p, q);
		} else {
			swapWithTemporaryVariable(arr, p, q);
		}

	}

	/**
	 * Swaps {@code arr[q]} with {@code arr[p]} with temp variable.
	 * 
	 * @param arr the array of characters
	 * @param p   first array index to swap
	 * @param q   second array index to swap
	 */
	private void swapWithTemporaryVariable(char[] arr, int p, int q) {
		var tmp = arr[p];
		arr[p] = arr[q];
		arr[q] = tmp;

	}

	/**
	 * Swaps {@code arr[q]} with {@code arr[p]} without temp variable (XOR swap)
	 * 
	 * @param arr the array of characters
	 * @param p   first array index to swap
	 * @param q   second array index to swap
	 * 
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/XOR_swap_algorithm">https://en.wikipedia.org/wiki/XOR_swap_algorithm</a>
	 */
	private void swapWithoutTempVar(char[] arr, int p, int q) {
		arr[p] = (char) (arr[p] ^ arr[q]);
		arr[q] = (char) (arr[p] ^ arr[q]);
		arr[p] = (char) (arr[p] ^ arr[q]);
	}

	/**
	 * Converts the character array to {@link String}
	 * 
	 * @param arr the array of characters
	 * @return the String containing the characters from the array
	 */
	private String getArrStr(char[] arr) {
		return String.valueOf(arr);
	}

	/**
	 * Prints the values in the array before and after running {@link #rgb(char[])}
	 * method.
	 * 
	 * @param rgbString the String containing the 'R','G' or 'B' characters.
	 */
	private void testRgb(String rgbString) {
		var arr = rgbString.toCharArray();
		System.out.format("Original:   %s%n", getArrStr(arr));
		rgb(arr);
		System.out.format("Segregated: %s%n", getArrStr(arr));
	}

	/**
	 * Tests the {@link #rgb(char[])} method
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		var app = new Pr35();
		app.testRgb("GBRRBRG");

	}

}
