package Problem71;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Problem71Test {

	@Test
	void testRand5() {
		Problem71 pr71 = new Problem71();
		int[] dist = new int[5];
		for (var i=0; i<10000; i++)  {
			int rand5 = pr71.rand5()-1;
			
			dist[rand5]++;
		}
		System.out.println(Arrays.toString(dist));
	}

}
