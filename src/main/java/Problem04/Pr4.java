package Problem04;

/**
 * This problem was asked by Stripe.
 * 
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0]
 * should give 3.
 * 
 * You can modify the input array in-place.
 */
public class Pr4 {

	class BitIndex {
		int byteIndex;
		int bitIndex;

		public BitIndex(int byteIndex, int bitIndex) {
			super();
			this.byteIndex = byteIndex;
			this.bitIndex = bitIndex;
		}
	}

	public int minMissingInteger(int... arr) {
		int maxBits = (int) Math.round(Integer.MAX_VALUE / 8 + 1);
		System.out.format("Allocating %d bytes...%n", maxBits);
		byte[] bitSet = new byte[maxBits];

		for (var number : arr) {
			if (number > 0) {
				setBit(bitSet, number);
			}
		}

		for (var i = 1; i < Integer.MAX_VALUE; i++) {
			if (!getBit(bitSet, i)) {
				return i;
			}
		}

		return -1;
	}

	private BitIndex getBitIndex(int number) {
		int byteIndex = number / 8;
		int bitIndex = number - byteIndex * 8;

		return new BitIndex(byteIndex, bitIndex);
	}

	private void setBit(byte[] bitSet, int number) {
		var index = getBitIndex(number);
		bitSet[index.byteIndex] |= 1 << index.bitIndex;
	}

	private boolean getBit(byte[] bitSet, int number) {
		var index = getBitIndex(number);
		return (bitSet[index.byteIndex] & (1 << index.bitIndex)) > 0 ? true : false;
	}

	public static void main(String... args) {

		var app = new Pr4();

		System.out.println(app.minMissingInteger(3, 4, -1, 1));
		System.out.println(app.minMissingInteger(1, 2, 0));

		System.out.println(app.minMissingInteger(Integer.MIN_VALUE, 0, 1, 2, 3, 4, 5, 6, Integer.MAX_VALUE));

	}

}
