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

	public static boolean check(int... arr) {
		var count = 0;
		for (var i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				if (count > 0) {
					return false;
				} else if (
				// corner case: [i-1]=5, [i]=6, [i+1]=4, [i+2]=5		
				// previous(i-1, may not exists) <- (low[i], high[i+1]) -> next(i+2, may not exists) 
				// the pair and the previous and next elements

				// index check
				i - 1 > 0 && // low's previous element is in the array
				i + 2 < arr.length && // high's next element is in the array

				// value check
				arr[i] > arr[i + 2] && // low is higher than high's next
				arr[i + 1] < arr[i - 1]) // high is less than low's previous
					
				{
					return false;
				}
				count++;
			}
		}
		return true;
	}

	
}
