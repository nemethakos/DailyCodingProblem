package Problem79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem79Test {

	@Test
	void testCouldBecomeNonDecreasing() {
		assertTrue(Problem79.couldBecomeNonDecreasing(10,5,7));
		assertFalse(Problem79.couldBecomeNonDecreasing(10,5,1));
	}

}
