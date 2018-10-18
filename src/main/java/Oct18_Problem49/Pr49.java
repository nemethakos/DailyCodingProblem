package Oct18_Problem49;

import java.util.Arrays;

public class Pr49 {

	/**
	 * Kadene's algorithm
	 * 
	 * @param array the array
	 * @return the sum of the maxumum sub array
	 */
	public static int maxSubArray(int[] array) {
		printArr(array);

		int globalMax = array[0];
		int currentMax = array[0];

		for (int i = 1; i < array.length; i++) {

			currentMax = Math.max(array[i], currentMax + array[i]);

			globalMax = Math.max(currentMax, globalMax);

		}

		return globalMax;
	}

	public static void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		System.out.println("max subarray: " + maxSubArray(new int[] { 34, -50, 42, 14, -5, 86 }));
		System.out.println("max subarray: " + maxSubArray(new int[] { -5, -1, -8, -9 }));
	}

}
