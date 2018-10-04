package Sep12;

public class Pr14Windowing {

	private static int longestSubstring(String text, int k) {
		int maxLongest = 0;
		CharWindow cw = new CharWindow(k);

		for (var i = 0; i < text.length(); i++) {
			int substringLength = cw.addChar(text.charAt(i));
			if (substringLength > maxLongest) {
				maxLongest = substringLength;
				System.out.println(cw.getAsString());
			}
		}
		return maxLongest;
	}

	public static void main(String... args) {
		System.out.println(longestSubstring("abcba",2));
	}

}
