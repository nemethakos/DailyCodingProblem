package Oct8_Problem40;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * This problem was asked by Google.
 * <p>
 * Given an array of integers where every integer occurs three times except for
 * one integer, which only occurs once, find and return the non-duplicated
 * integer.
 * <p>
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13],
 * return 19.
 * <p>
 * Do this in O(N) time and O(1) space.
 * <p>
 * Reference: <a href=
 * "https://www.geeksforgeeks.org/find-the-element-that-appears-once/">https://www.geeksforgeeks.org/find-the-element-that-appears-once/</a>
 * 
 */
public class Pr40 {

	private static String bin(int value) {
		return StringUtils.leftPad(Integer.toBinaryString(value) + "b", 9, ' ') + ","
				+ StringUtils.leftPad(Integer.toString(value), 3, ' ');
	}

	public static int getElementWhichOnlyOccuresOnce(int[] arr) {
		System.out.print("arr[] = int[] {");
		for (var i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("};");

		var singlyBits = 0;
		var doublyBits = 0;

		for (var i = 0; i < arr.length; i++) {
			System.out.println();
			System.out.println("singlyBits:\t\t\t\t\t\t" + bin(singlyBits));
			System.out.println("doublyBits:\t\t\t\t\t\t" + bin(doublyBits));
			var arrayElement = arr[i];
			System.out.println("arrayElement = arr[" + i + "]:" + "\t\t\t\t\t" + bin(arrayElement));

			/**
			 * Get the bits which are common in "singlyBits" and "arrayElement"
			 */
			var commonBits = singlyBits & arrayElement;
			System.out.println("commonBits = singlyBits & arrayElement:\t\t\t" + bin(commonBits));

			/**
			 * Set the common bits in "doublyBits"
			 */
			doublyBits = doublyBits | commonBits;
			System.out.println("doublyBits = doublyBits | commonBits:\t\t\t" + bin(doublyBits));

			/**
			 * Flip bits in "singlyBits" which are set in arrayElement
			 */
			singlyBits = singlyBits ^ arrayElement;
			System.out.println("singlyBits = singlyBits ^ arrayElement:\t\t\t" + bin(singlyBits));

			/**
			 * The bits in "singlyBits" and "doublyBits" which are appears third time in the
			 * array are set to 1 in both variable
			 */
			int bitsThatAppearThirdTime = singlyBits & doublyBits;
			System.out
					.println("bitsThatAppearThirdTime = singlyBits & doublyBits:\t" + bin(bitsThatAppearThirdTime));

			/**
			 * remove bits that appear the third time from "singlyBits"
			 */
			singlyBits = singlyBits & ~bitsThatAppearThirdTime;
			System.out.println("singlyBits = singlyBits & ~bitsThatAppearThirdTime:\t" + bin(singlyBits));

			/**
			 * remove bits that appear the third time from "doublyBits"
			 */
			doublyBits = doublyBits & ~bitsThatAppearThirdTime;
			System.out.println("doublyBits = doublyBits & ~bitsThatAppearThirdTime:\t" + bin(doublyBits));

		}
		System.out.println("------------------------------------------------");
		System.out.println("Result: (singlyBits):\t\t\t\t\t" + bin(singlyBits));
		System.out.println("------------------------------------------------");
		return singlyBits;
	}

	public static void main(String... args) {
		// getElementWhichOnlyOccuresOnce(new int[] { 6, 1, 3, 3, 3, 6, 6 });
		// getElementWhichOnlyOccuresOnce(new int[] { 13, 19, 19, 19 });
		getElementWhichOnlyOccuresOnce(new int[] { 1, 2, 2, 2 });

	}

}
