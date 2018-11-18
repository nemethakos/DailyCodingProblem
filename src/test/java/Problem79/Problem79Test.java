package Problem79;

import org.junit.jupiter.api.Test;

import static Problem79.Problem79.check;
import static org.junit.jupiter.api.Assertions.*;

class Problem79Test {

	@Test
	void testCouldBecomeNonDecreasing() {

		// positive case 
		assertTrue(check(1, 2, 3, 4));

		// positive case
		assertTrue(check(10, 5, 7));

		// negative corner case
		assertFalse(check(5, 6, 4, 5));

		// negative case
		assertFalse(check(10, 5, 1));
	}

}
