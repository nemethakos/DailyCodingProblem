package Problem12;

public class Problem12 {

	private int staircase(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			return staircase(n - 1) + staircase(n - 2);
		}
	}
	
	public static void main(String...args) {
		var p12 = new Problem12();
		
		System.out.println(p12.staircase(4));
	}

}
