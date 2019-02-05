package Problem159;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Pr159Test {

	@FunctionalInterface
	interface FirstRecurringChar {
		Character getFirstRecurringChar(String s);
	}

	String getString(int length, boolean haveMissingChar, char missingChar, boolean ascii) {

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			if (!(haveMissingChar && missingChar == i)) {
				if (ascii) {
					sb.append((char) (i & 0xFF));
				} else {
					sb.append((char) i);
				}
			}
		}

		//System.out.println(sb);
		return sb.toString();
	}

	@Test
	void testGetFirstRecurringCharUnicode() {
		assertNull(Pr159.getFirstRecurringCharUnicode(""));

		assertNull(Pr159.getFirstRecurringCharUnicode("abc"));

		assertEquals(Character.valueOf('a'), Pr159.getFirstRecurringCharUnicode("abcdefghijklmnopqa"));

		assertEquals(Character.valueOf('a'), Pr159.getFirstRecurringCharUnicode("aa"));

	}

	private long benchmark(String title, String rndStr, FirstRecurringChar firstRecurringChar, int warmupCycles, int benchMarkCycles) {

		
		for (int i=0; i<warmupCycles; i++) {
			assertEquals(Character.valueOf('a'), firstRecurringChar.getFirstRecurringChar(rndStr));
		}
		
		long start = 0, end = 0;
		start = System.nanoTime();

		for (int i = 0; i < benchMarkCycles; i++) {

			// System.out.format("Iteration %d stars...\n", i);

			assertEquals(Character.valueOf('a'), firstRecurringChar.getFirstRecurringChar(rndStr));

			//System.out.format("Iteration: %d, time: %d\n", i, (end - start));
		}
		end = System.nanoTime();

		System.out.format("%s: cycles: %d, String length: %d, time: %dns\n", title, benchMarkCycles, rndStr.length(), (end - start));
		
		return end-start;
	}

	@Test
	void testGetFirstRecurringCharASCII() {
		assertNull(Pr159.getFirstRecurringCharASCII(""));

		assertNull(Pr159.getFirstRecurringCharASCII("abc"));

		assertEquals(Character.valueOf('a'), Pr159.getFirstRecurringCharASCII("aa"));

		assertEquals(Character.valueOf('a'), Pr159.getFirstRecurringCharASCII("abcdefghijklmnopqa"));

		assertEquals(Character.valueOf('a'), Pr159.getFirstRecurringCharASCII("aa"));

		


	}
	
	@Test
	void benchmark() {
		String rndStr = getString(127, true, 'a', false) + "aa";

		long hashMapTime = benchmark("HashSet implementation", rndStr, (String s) -> {
			return Pr159.getFirstRecurringCharUnicode(s);
		}, 1000, 1_000_000);
		
		long arrayTime = benchmark("array implementation  ", rndStr, (String s) -> {
			return Pr159.getFirstRecurringCharASCII(s);
		},1000, 1_000_000);
		
		
		System.out.format("Speed difference: %f", ((double)hashMapTime/(double)arrayTime));
		
	}

}
