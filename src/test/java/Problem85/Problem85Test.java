package Problem85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem85Test {

	public static final int RETURN_X = 1;
	public static final int RETURN_Y = 0;

	@Test
	void testReturnXorY() {
		int x = 1111;
		int y = 2222;
		assertEquals(x, Problem85.returnXorY(x, y, RETURN_X));
		assertEquals(y, Problem85.returnXorY(x, y, RETURN_Y));
	}

}
