package Problem159;

import java.util.HashSet;
import java.util.Set;

public class Pr159 {

	public static Character getFirstRecurringCharUnicode(String s) {
		Set<Character> seen = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (seen.contains(c)) {
				return c;
			} else {
				seen.add(c);
			}
		}
		return null;
	}

	public static Character getFirstRecurringCharASCII(String s) {
		boolean[] map = new boolean[255];
		byte[] bytes = s.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			
			if (map[bytes[i]]) {
				return Character.valueOf((char)bytes[i]);
			} else {
				map[bytes[i]] = true;
			}
		}
		return null;
	}

}
