package Problem82;

import org.junit.jupiter.api.Test;

import static Problem82.Problem82.readN;
import static org.junit.Assert.assertEquals;

import Problem82.Problem82.Read7;

class Problem82Test {

	@Test
	void testRead7() {
		Read7 read7 = new Read7("0123456789");
		assertEquals("0123456",read7.read7());
		assertEquals("789",read7.read7());
		assertEquals("",read7.read7());
	}
	
	@Test
	void testReadN() {
		Read7 read7 = new Read7("Hello World!");
		assertEquals("Hello World!", readN(read7, 12));
	}
	

}
