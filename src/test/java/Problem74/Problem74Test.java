package Problem74;

import org.junit.jupiter.api.Test;

class Problem74Test {

	@Test
	void testGetNumberOfTimesXAppearAsAValueInAnNByNMultiplicationTable() {
		Problem74 pr74 = new Problem74();
		var count = pr74.getNumberOfTimesXAppearAsAValueInAnNByNMultiplicationTable(6, 12);
		System.out.println("n=6, x=12, count="+count);
	}

}
