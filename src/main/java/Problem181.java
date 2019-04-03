import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem181 {

	private static class Char {
		char character;
		int index;

		public Char(char c, int index) {
			this.character = c;
			this.index = index;
		}

		public Char(String str, int index) {
			super();
			this.character = str.charAt(index);
			this.index = index;
		}

		@Override
		public String toString() {
			return String.format("Char [character=%s, index=%s]", character, index);
		}

		public static Char getSentinel() {
			return new Char((char) 0, 0);
		}

		public static boolean isSentinel(Char c) {
			return c.character == 0;
		}

	}

	private static boolean isAnagramma(Char first, Char last) {
		return first != null && last != null && first.character == last.character && first != last;
	}

	public static List<String> splitPalindromes(String text) {
		var result = new ArrayList<String>();

		if (text == null || text.length() == 0) {
			return result;
		}

		Deque<Char> stack = new LinkedList<>();
		Char first = null;
		Char current = null;
		Char last = null;
		Char top = null;

		stack.push(Char.getSentinel());
		stack.push(Char.getSentinel());
		
		stack.push(new Char(text, 0));
		int i = 1;
		while (i < text.length()) {
			last = current;
			current = new Char(text, i);
			top = stack.peek();
			char next = 0;
			if (i<text.length()-1) {
				next = text.charAt(i+1);
			}
			var tmp = stack.pop();
			var topBefore = stack.peek();
			stack.push(tmp);
			boolean popped = false;

			if (current.character == topBefore.character) {
				stack.pop();
				first = stack.pop();
				popped = true;
			}
			if (current.character == top.character && next != current.character) {
				popped = true;
				first = stack.pop();
			}
			if (popped) {
				if (checkAndOutputAnagramma(text, result, first, last)) {
					first = null;
					stack.push(current);
					i++;
				} else {
					stack.push(current);
				}
			}

			i++;
		}

		last = current;

		checkAndOutputAnagramma(text, result, first, last);

		Deque<Char> reverse = new LinkedList<>();
		while (!stack.isEmpty()) {
			Char c = stack.pop();
			if (!Char.isSentinel(c)) {
				reverse.push(c);
			}
		}
		while (!reverse.isEmpty()) {
			result.add(String.valueOf(reverse.pop().character));
		}

		return result;
	}

	private static boolean checkAndOutputAnagramma(String text, ArrayList<String> result, Char first, Char last) {
		if (isAnagramma(first, last)) {
			result.add(text.substring(first.index, last.index + 1));
			return true;
		}
		return false;
	}

}
