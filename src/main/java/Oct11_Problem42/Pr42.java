package Oct11_Problem42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * <p>
 * This problem was asked by Google.
 * <p>
 * Given a list of integers <em>S</em> and a target number <em>k</em>, write a
 * function that returns a <em>subset of S</em> that adds <em>up to k</em>. If
 * such a subset cannot be made, then return <code>null</code>.
 * <p>
 * Integers can appear more than once in the list. You may assume all numbers in
 * the list are <em>positive</em>.
 * <p>
 * For example, given <code>S = [12, 1, 61, 5, 9, 2]</code> and
 * <code>k = 24</code>, return <code>[12, 9, 2, 1]</code> since it sums up to
 * <em>24</em>.
 */
public class Pr42 {

	/**
	 * Returns <code>List&lt;Integer&gt;</code> subset to have a sum closer to
	 * <code>targetSum</code>
	 * 
	 * @param subset     the current subset
	 * @param subsetSum  the current sum of the subset
	 * @param complement the complementer set (subset + complement = original set)
	 * @param targetSum  the sum to have when the subset is found
	 * @return the possible values to be added to the subset
	 */
	private static List<Integer> possibleValuesList(int subsetSum, List<Integer> complement, int targetSum) {
		List<Integer> result = new ArrayList<>();

		for (var value : complement) {
			if (subsetSum + value <= targetSum) {
				result.add(value);
			}
		}

		return result;
	}

	/**
	 * Backtracking algorithm to find one possible subset with the sum of
	 * <code>targetSum</code>
	 * 
	 * @param result     if the subset is found, result contains the subset with the
	 *                   sum of <code>targetSum</code>
	 * @param subset     the working subset
	 * @param complement complement = original set - subset
	 * @param targetSum  the sum of the subset to find
	 * @return true, if the subset is found, false if not found
	 */
	private static boolean subsetForSum(List<Integer> result, List<Integer> subset, List<Integer> complement,
			int targetSum) {
		int subsetSum = sum(subset);
		if (subsetSum > targetSum) {
			return false;
		} else if (subsetSum == targetSum) {
			return true;
		} else if (subsetSum < targetSum) {
			var possibleValuesToAdd = possibleValuesList(subsetSum, complement, targetSum);
			for (var possibleValue : possibleValuesToAdd) {
				subset.add(possibleValue);
				complement.remove(possibleValue);
				result.clear();
				result.addAll(subset);
				boolean found = subsetForSum(result, subset, complement, targetSum);
				if (found) {
					return true;
				}
				complement.add(possibleValue);
				subset.remove(possibleValue);
			}
		}
		return false;
	}

	private static int sum(List<Integer> subset) {
		return subset.stream().reduce(0, Integer::sum);
	}

	public static List<Integer> getSubSet(List<Integer> numbers, int targetSum) {
		List<Integer> result = new ArrayList<Integer>();

		numbers.sort((a, b) -> a - b);

		List<Integer> subset = new ArrayList<>();
		List<Integer> complement = new ArrayList<>(numbers);

		if (!subsetForSum(result, subset, complement, targetSum)) {
			return null;
		}

		return result;
	}

	/**
	 * Brute-force algorithm to find the subset with the sum of
	 * <code>targetSum</code>
	 * 
	 * @param numbers   the set of numbers
	 * @param targetSum the sum of the subset to find
	 * @return the resulting subset or null if none found
	 */
	public static List<Integer> bruteForceSubSet(List<Integer> numbers, int targetSum) {
		var numbersSet = new HashSet<Integer>(numbers);

		var powerSet = Sets.powerSet(numbersSet);

		for (var set : powerSet) {
			if (sum(set) == targetSum) {
				return new ArrayList<Integer>(set);
			}
		}
		return null;

	}

	private static int sum(Set<Integer> set) {

		return set.stream().reduce(0, Integer::sum);
	}

	/**
	 * Runs the backtracking and the brute-force algorithm (as the control) to find
	 * the subset with the sum <code>targetValue</code>
	 * 
	 * @param set         the list of numbers to use
	 * @param targetValue the sum
	 * @return true, if the same result is returned by the backtracking and the
	 *         brute-force
	 */
	public static boolean printSubset(List<Integer> set, int targetValue) {

		List<Integer> backtrackSubset = getSubSet(set, targetValue);
		List<Integer> bruteForceSubSet = bruteForceSubSet(set, targetValue);
		HashSet<Integer> btSet = null;
		HashSet<Integer> bfSet = null;
		if (backtrackSubset != null) {
			btSet = new HashSet<Integer>(backtrackSubset);
		}
		if (bruteForceSubSet != null) {
			bfSet = new HashSet<Integer>(bruteForceSubSet);
		}
		boolean ok = Objects.equals(btSet, bfSet);

		if (!ok && btSet != null) {
			var btSum = sum(btSet);
			ok = btSum == targetValue;
		}

		if (!ok || bfSet != null) {
			System.out.println("Sum: " + targetValue + ", matching: " + ok + ", backtrack: " + backtrackSubset
					+ ", brute-force: " + bruteForceSubSet);
		}
		return ok;
	}

	/**
	 * Test the brute-force and the backtracking approach
	 * 
	 * @param numbers the set to use
	 * @param start   starting target sum
	 * @param end     end target sum
	 */
	private static void testBacktrackAndBruteForce(List<Integer> numbers, int start, int end) {
		
		System.out.println("Testing with set: " + numbers + ", sum from: " + start + " to " + end);
		
		boolean correct = true;
		for (int i = start; i <= end; i++) {
			correct &= printSubset(numbers, i);
		}
		System.out.println("All results correct: " + correct);
	}

	public static void main(String... args) {

		List<Integer> numbers = Arrays.asList(12, 1, 61, 5, 9, 2);
	
		testBacktrackAndBruteForce(numbers, 0, 100);

	}

}
