import org.junit.jupiter.api.Test;

class Problem181Test {

	@Test
	void testSplitPalindromes() {
	/*
		testAnagrammaSplit(null);

		
		testAnagrammaSplit("");

		
		testAnagrammaSplit("a");
		
		testAnagrammaSplit("aa");*/

		testAnagrammaSplit("aaa");

		testAnagrammaSplit("abba");
		
		testAnagrammaSplit("aba");
		
		testAnagrammaSplit("racecarannakayak");
		
		testAnagrammaSplit("abc");
	}

	private void testAnagrammaSplit(String text) {
		System.out.format("\"%s\" -> %s\n", text, Problem181.splitPalindromes(text));
	}

}
