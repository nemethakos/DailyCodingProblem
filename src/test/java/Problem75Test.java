import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Problem75.Problem75;

class Problem75Test {

	@Test
	void testGetLongestIncreasingSubsequenceIntArray() {
		Problem75 pr75 = new Problem75();
		System.out.println(pr75
				.getLongestIncreasingSubsequence(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
		
		System.out.println(pr75
				.getLongestIncreasingSubsequenceWithDynamicProgramming(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
	}

}
