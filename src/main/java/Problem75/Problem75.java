package Problem75;
import java.util.List;

/**
 * <p>
 * Given an array of numbers, find the length of the longest increasing
 * subsequence in the array. The subsequence does not necessarily have to be
 * contiguous.
 * 
 * <p>
 * For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11,
 * 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9,
 * 11, 15.
 */
public class Problem75 {

	public int getLongestIncreasingSubsequence(List<Integer> arr) {
		if (arr.size() == 0) {
			return 0;
		}
		if (arr.size() == 1) {
			return 1;
		}

		int longestSubsequenceLength = 0;

		for (var i = 1; i < arr.size() - 1; i++) {

			int subsequenceLengthUpToIthIndex = getLongestIncreasingSubsequence(arr.subList(0, i));

			if (arr.get(arr.size() - 1) > arr.get(i - 1)) {

				if (subsequenceLengthUpToIthIndex + 1 > longestSubsequenceLength) {
					longestSubsequenceLength = subsequenceLengthUpToIthIndex + 1;
				}
			}
		}
		return longestSubsequenceLength;
	}

	public int max(int[] arr) {
		int result = Integer.MIN_VALUE;
		for (var i = 0; i < arr.length; i++) {
			result = Math.max(result, arr[i]);
		}
		return result;
	}

	public int getLongestIncreasingSubsequenceWithDynamicProgramming(List<Integer> arr) {

		int[] cache = new int[arr.size()];
		for (var i=0; i<cache.length; i++) {
			cache[i]=1;
		}

		for (var endIndex = 0; endIndex < arr.size(); endIndex++) {

			for (var startIndex = 0; startIndex < endIndex; startIndex++) {

				if (arr.get(endIndex) > arr.get(startIndex)) {
		
					cache[endIndex] = Math.max(cache[endIndex], cache[startIndex] + 1);
				
				}

			}
		}
		
		return max(cache);
	}

}
