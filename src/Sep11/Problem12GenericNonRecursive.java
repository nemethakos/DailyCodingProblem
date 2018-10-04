package Sep11;

public class Problem12GenericNonRecursive {

	private long staircase(int n, int... steps) {

		long[] prev = new long[n + 1];
		prev[0] = 1;

		for (int i = 1; i <= n; i++) {

			long sum = 0;
			for (var j = 0; j < steps.length; j++) {

				if (i >= steps[j]) {
					sum += prev[i - steps[j]];
				}
			}
			prev[i] = sum;
		}
		for (var i=0; i<prev.length; i++) {
			System.out.print("["+i+"]="+prev[i]+",");
			
		}System.out.println();
		return prev[n];
	}

	public static void main(String... args) {
		var p12 = new Problem12GenericNonRecursive();

		System.out.println(p12.staircase(200, 3,5));
	}

}
