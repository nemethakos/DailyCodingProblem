package Sep11;

public class Problem12Generic {

	private int staircase(int n, int... steps) {

		//System.out.println(n);
		
		// base case
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		}

		// recursive algorithm
		int sum = 0;
		for (var i = 0; i < steps.length; i++) {

			if (n >= steps[i]) {
				sum += staircase(n - steps[i], steps);
			}
		}
		return sum;

	}

	public static void main(String... args) {
		var p12 = new Problem12Generic();

		System.out.println(p12.staircase(60, 3, 5));
	}

}
