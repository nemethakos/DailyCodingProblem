package Problem81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Given a mapping of digits to letters (as in a phone number), and a digit
 * string, return all possible letters the number could represent. You can
 * assume each valid number in the mapping is a single digit.
 * 
 * <p>
 * For example if
 * 
 * <pre>
 * {"2": [“a”, “b”, “c”], 
 *  "3": [“d”, “e”, “f”], …}
 * </pre>
 * 
 * then
 * 
 * <code>
 * "23"
 * </code>
 * 
 * should return
 * 
 * <code>
 * [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"]
 * </code>
 *
 */
public class Problem81 {

	/**
	 * Iterative implementation. Generates all permutation.
	 * <p>
	 * Time complexity: O(p*v*k), where
	 * <ul>
	 * <li>p is the number of possible permutations.
	 * <li>v is the number of distinct values 
	 * <li>k is the number of characters in numbersPressed
	 * </ul>
	 * <p>
	 * Space complexity: O(k), where k is the number of characters in the
	 * numbersPressed
	 * 
	 * @param map
	 * @param numbersPressed
	 * @return
	 */
	public static List<String> getAllPossibleRepresentationsIterative(Map<String, List<String>> map,
			String numbersPressed) {

		List<String> result = new ArrayList<>();

		// one counter for each key pressed, plus one for the overflow
		int[] counters = new int[numbersPressed.length() + 1];
		// iterate until the overflow counter becomes 1
		while (counters[numbersPressed.length()] != 1) {
			
			String permutation = getPermutation(map, counters, numbersPressed);
			result.add(permutation);
			System.out.println("counters: " + Arrays.toString(counters) + ", permutation: "+ permutation);
			increaseCounter(map, counters, numbersPressed);
		}

		return result;
	}

	/**
	 * Treat the counters array as the digits of a number. This method adds one to
	 * the number represented by the digits
	 * 
	 * @param map            the map of keypresses to letters
	 * @param counters       the array of counters
	 * @param numbersPressed the pressed keys
	 */
	private static void increaseCounter(Map<String, List<String>> map, int[] counters, String numbersPressed) {
		counters[0]++;
		for (var i = 0; i < counters.length - 1; i++) {
			String pressedKey = "" + numbersPressed.charAt(i);
			int maxValueForDigit = map.get(pressedKey).size();
			if (counters[i] >= maxValueForDigit) {
				counters[i] = 0;
				counters[i + 1]++;
			}
		}
	}

	/**
	 * Returns the permutation according to the counters
	 * 
	 * @param map            the map of keypresses to letters
	 * @param counters       the array of counters
	 * @param numbersPressed the pressed keys
	 * @return the permutation according to the counters
	 */
	private static String getPermutation(Map<String, List<String>> map, int[] counters, String numbersPressed) {

		StringBuilder sb = new StringBuilder(counters.length - 1);

		for (var i = 0; i < counters.length - 1; i++) {
			String pressedKey = "" + numbersPressed.charAt(i);
			List<String> mappedLetters = map.get(pressedKey);
			String currentLetter = mappedLetters.get(counters[i]);
			sb.append(currentLetter);
		}

		return sb.toString();
	}

	/**
	 * Recursive implementation
	 * 
	 * @param map            the map of phone key->possible letters
	 * @param numbersPressed the phone keys pressed
	 * @return the list of possible representation
	 */
	public static List<String> getAllPossibleRepresentationsRecursive(Map<String, List<String>> map,
			String numbersPressed) {
		List<String> result = new ArrayList<>();

		// base case
		if (numbersPressed.length() == 0) {
			result.add("");
			return result;
		} else {

			// reduction case
			var allRepresentations = getAllPossibleRepresentationsRecursive(map,
					numbersPressed.substring(0, numbersPressed.length() - 1));

			// the last letters which will be permutated using the representations returned
			// by the n-1 case
			var lastLetters = map.get(numbersPressed.substring(numbersPressed.length() - 1, numbersPressed.length()));

			// generating permutations
			for (var representation : allRepresentations) {
				for (var letter : lastLetters) {
					result.add(representation + letter);
				}
			}

			return result;
		}

	}

}
