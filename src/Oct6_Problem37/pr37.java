package Oct6_Problem37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This problem was asked by Google.
 * 
 * The power set of a set is the set of all its subsets. Write a function that,
 * given a set, generates its power set.
 * 
 * For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3},
 * {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 * 
 * You may also use a list or array to represent a set.
 */
public class pr37 {

	public List<List<Integer>> getPowerSet(List<Integer> set) {
		List<List<Integer>> result = new ArrayList<>();

		long maxElements = (long) Math.pow(2, set.size());
		for (long i = 0; i < maxElements; i++) {
			result.add(getConfiguration(set, i));
		}

		return result;
	}

	private List<Integer> getConfiguration(List<Integer> set, long configuration) {
		
		List<Integer> result = new ArrayList<>();
		var index = 0;

		while (configuration > 0) {
			boolean included = (configuration & 1) == 1;
			if (included) {
				result.add(set.get(index));
			}
			index++;
			configuration >>= 1;
		}

		return result;
	}

	public static void main(String[] args) {
		pr37 app = new pr37();
		System.out.println(app.getPowerSet(Arrays.asList(1,2,3)));
		
	}

}
