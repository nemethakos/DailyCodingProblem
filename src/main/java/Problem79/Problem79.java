package Problem79;

/**
 * Given an array of integers, write a function to determine whether the array
 * could become non-decreasing by modifying at most 1 element.
 * 
 * For example, given the array [10, 5, 7], you should return true, since we can
 * modify the 10 into a 1 to make the array non-decreasing.
 * 
 * Given the array [10, 5, 1], you should return false, since we can't modify
 * any one element to get a non-decreasing array.
 */
public class Problem79 {

	/**
	 * Returns true, if the array can be modified to become non decreasing
	 * 
	 * @param arr the array
	 * @return true, if the array can be modified to become non decreasing, false
	 *         otherwise
	 */
	public static boolean couldBecomeNonDecreasing(int... arr) {

		// null array or 0 or 1 element array counts as already non decreasing
		if (arr == null || arr.length < 2) {
			return true;
		}

		var counter = 0;
		for (var i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				counter++;
			}
		}

		return counter <= 1;
	}

}
