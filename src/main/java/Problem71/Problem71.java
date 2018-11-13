package Problem71;

import java.util.Random;

/**
 * Using a function rand7() that returns an integer from 1 to 7 (inclusive) with
 * uniform probability, implement a function rand5() that returns an integer
 * from 1 to 5 (inclusive). 
 */
public class Problem71 {

	Random rnd = new Random();

	public int rand7() {
		return rnd.nextInt(7) + 1;
	}

	public int rand5() {
		int random5;
		do {
			random5 = rand7();
			System.out.println(random5);
		} while (random5 > 5);
		return random5;
	}
}
