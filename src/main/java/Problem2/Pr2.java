package Problem2;

/**
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 * 
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
 * be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
 */

public class Pr2 {

	public static long[] getProductOfArray(long... arr) {
		long[] result = new long[arr.length];
		long totalProduct = 1;

		for (var element : arr) {
			totalProduct *= element;
		}

		for (var i = 0; i < arr.length; i++) {
			result[i] = totalProduct / arr[i];
		}

		return result;
	}

	public static long[] getProductOfArrayNoDivision(long... arr) {
		long[] result = new long[arr.length];
		for (var i = 0; i < arr.length; i++) {
			var product = 1;
			for (var j = 0; j < arr.length; j++) {
				if (j != i) {
					product *= arr[j];
				}
			}
			result[i] = product;
		}
		return result;
	}

	public static void printArr(long[] arr) {
		System.out.print("[");
		for (var i = 0; i < arr.length; i++) {

			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public static void main(String... args) {

		printArr(getProductOfArray(1, 2, 3, 4, 5));
		printArr(getProductOfArray(3, 2, 1));

		printArr(getProductOfArrayNoDivision(1, 2, 3, 4, 5));
		printArr(getProductOfArrayNoDivision(3, 2, 1));
	}

}
