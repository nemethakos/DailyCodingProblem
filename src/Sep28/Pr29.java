package Sep28;

import java.util.Collections;

public class Pr29 {

	public static String convertTextToRLE(String text) {
		StringBuilder sb = new StringBuilder(text.length());
		int i = 0;
		while (i < text.length()) {
			char c = text.charAt(i);
			int j = i + 1;
			while (j < text.length() && c == text.charAt(j)) {
				j++;
			}
			sb.append(c);
			int runLength = j - i;
			if (runLength > 1) {
				sb.append(String.valueOf(runLength));
			}
			i = j;
		}
		return sb.toString();
	}

	public static String convertRLEToText(String text) {
		StringBuilder sb = new StringBuilder(text.length());
		int i = 0;
		while (i < text.length()) {
			int j = i + 1;
			while (j < text.length() && Character.isDigit(text.charAt(j))) {
				j++;
			}
			if (j > i + 1) {
				Integer runLength = Integer.valueOf(text.substring(i + 1, j + 1));
				sb.append(Collections.nCopies(runLength, text.charAt(i)));
			} else {
				sb.append(text.charAt(i));
			}
			i = j;
		}
		return sb.toString();
	}

	public static void test(String text) {
		String encoded = convertTextToRLE(text);
		System.out.println("Encoded: " + encoded);
		String decoded = convertRLEToText(text);
		System.out.println("Decoded: " + decoded);
		System.out.println("Equals: " + text.equals(decoded));
	}

	public static void main(String[] args) {
		test("ABBA");
	}

}
