package Problem85;

/**
 * Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0,
 * using only mathematical or bit operations. You can assume b can only be 1 or
 * 0.
 */
public class Problem85 {

	public static int returnXorY(int x, int y, int b) {
		return x * b + y * (1 - b);
	}
	
	
}
