package Problem82;

/**
 * <p>
 * Using a <code>read7()</code> method that returns 7 characters from a file,
 * implement <code>readN(n)</code> which reads <code>n</code> characters.
 * 
 * <p>
 * For example, given a file with the content <code>“Hello world”</code>, three
 * <code>read7()</code> returns <code>“Hello w”</code>, <code>“orld”</code> and
 * then <code>“”</code>.
 */
public class Problem82 {

	public static class Read7 {
		private String buffer;
		private int index;

		public Read7(String text) {
			this.buffer = text;
		}

		public String read7() {
			if (index >= buffer.length()) {
				return "";
			}
			var endIndex = Math.min(index + 7, buffer.length());
			String result = buffer.substring(index, endIndex);
			index = endIndex;
			return result;
		}
	}

	public static String readN(Read7 read7, int numChars) {
		StringBuilder sb = new StringBuilder();

		while (numChars > 0) {
			sb.append(read7.read7());
			numChars -= 7;
		}

		return sb.toString();
	}

}
