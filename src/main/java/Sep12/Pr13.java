package Sep12;

import java.util.HashSet;
import java.util.Set;

public class Pr13 {

	private static int longestSubstring(String text, int k) {
		int maxLongest = 0;
		Set<Character> set = new HashSet<>();
		int i;
		int longest;

		for (i = 0; i < text.length(); i++) {
			set.clear();
			for (longest = 0; longest < text.length() - i; longest++) {
				set.add(text.charAt(i + longest));
				if (set.size() > k) {
					break;
				}
			}
			if (longest > maxLongest) {
				maxLongest = longest;
				System.out.println("longest: '" + text.substring(i, i+longest) + "', length: " + maxLongest + ", i="+i);
			}
		}
		return maxLongest;
	}

	public static void main(String... args) {
		System.out.println(longestSubstring("wreiuzworuhfkljsacnas ndhukihfckasdlfkjsdhfababababababababababababbaaaabbababababbabababaabbababbab", 2));
	}

}
