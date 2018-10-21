package Problem31;

/**
 * This problem was asked by Google.
 * 
 * The edit distance between two strings refers to the minimum number of
 * character insertions, deletions, and substitutions required to change one
 * string to the other. For example, the edit distance between “kitten” and
 * “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”,
 * and append a “g”.
 * 
 * Given two strings, compute the edit distance between them.
 *
 */
public class App {

	public static int getEditDistance(String changed, String original) {
		int changedPointer = 0;
		int originalPointer = 0;
		int editDistance = 0;
		int originalMoved = 0;
		int changedMoved = 0;
		int startOriginal = 0;
		int startChanged = 0;

		while (changedPointer < changed.length() && originalPointer < original.length()) {
			startOriginal = originalPointer;
			startChanged = changedPointer;

			// skip identical characters
			while (changedPointer < changed.length() && originalPointer < original.length()
					&& changed.charAt(changedPointer) == original.charAt(originalPointer)) {
				changedPointer++;
				originalPointer++;
			}

			printIdenticalParts(changed, original, changedPointer, originalPointer, startOriginal, startChanged);

			if (originalPointer < original.length() && changedPointer < changed.length()) {
				startOriginal = originalPointer;
				startChanged = changedPointer;

				// move changed pointer until matches
				while (changedPointer < changed.length()
						&& changed.charAt(changedPointer) != original.charAt(originalPointer)) {
					changedPointer++;
				}

				int changedPtr = startChanged;

				// move original pointer until matches
				while (originalPointer < original.length()
						&& original.charAt(originalPointer) != changed.charAt(changedPtr)) {
					originalPointer++;
				}

				originalMoved = originalPointer - startOriginal;
				changedMoved = changedPointer - startChanged;

				printChangedParts(changed, original, changedPointer, originalPointer, originalMoved, changedMoved,
						startOriginal, startChanged);

				editDistance++;
			}
		}

		if (original.length() != changed.length()) {
			printChangedParts(changed, original, changedPointer, originalPointer, originalMoved, changedMoved,
					startOriginal, startChanged);

			editDistance++;
		}

		return editDistance;
	}

	private static void printIdenticalParts(String changed, String original, int changedPointer, int originalPointer,
			int startOriginal, int startChanged) {
		if (startOriginal != originalPointer) {
			System.out.println("IDENTICAL: Original: '" + original.substring(startOriginal, originalPointer)
					+ "', Changed: '" + changed.substring(startChanged, changedPointer) + "'");
		}
	}

	private static void printChangedParts(String changed, String original, int changedPointer, int originalPointer,
			int originalMoved, int changedMoved, int startOriginal, int startChanged) {
		String originalPart = original.substring(startOriginal, originalPointer);
		String changedPart = changed.substring(startChanged, changedPointer);

		if (originalMoved > changedMoved) {
			System.out.println("DELETED:     ");
		} else if (changedMoved > originalMoved) {
			System.out.println("INSERTED:    ");
		} else {
			System.out.println("SUBSTITUTED: ");
		}
		System.out.println("Original:'" + originalPart + "', Changed:'" + changedPart + "'");
	}

	public static void main(String[] args) {
		// System.out.println(getEditDistance("abcd", "abcde"));
		System.out.println(getEditDistance("kitten", "sitting"));

	}

}
