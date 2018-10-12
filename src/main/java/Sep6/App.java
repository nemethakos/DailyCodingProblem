package Sep6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

	Map<String, Integer> variants = new HashMap<>();

	public App() {
		for (var i = 1; i <= 26; i++) {
			variants.put(String.valueOf(i), 1);
		}
		for (var i = 27; i <= 99; i++) {
			variants.put(String.valueOf(i), 0);
		}
		variants.put("", 1);
	}

	private static String safeSubString(String string, int startIndex, int endIndex) {

		if (string.length() == 0 || endIndex < 0) {
			return "";
		}
		if (startIndex >= string.length()) {
			return "";
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (endIndex > string.length()) {
			endIndex = string.length();
		}

		return string.substring(startIndex, endIndex);
	}

	private static Triplet getTriplet(String message, int index, int length) {
		// System.out.println("Source: " + message + ", index: " + index + ", length: "
		// + length);
		var triplet = new Triplet(//
				safeSubString(message, 0, index - 1), //
				safeSubString(message, index - 1, index + length - 1), //
				safeSubString(message, index + length - 1, message.length()));

		// System.out.println("Source: " + message + ", index: " + index + ", length: "
		// + length + ", result: " + triplet.getStringList());

		return triplet;
	}

	private List<Triplet> getAllTriplets(String text) {
		Set<Triplet> set = new HashSet<>();

		for (int i = 1; i < text.length(); i++) {
			for (int j = 1; j <= 2; j++) {
				Triplet subTriplet = getTriplet(text, i, j);
				set.add(subTriplet);
			}
		}

		return new ArrayList<>(set);
	}

	private int numberOfWaysTheMessageCanBeDecoded(Triplet triplet) {

		int result = 1;
		for (var subMessage : triplet.getStringList()) {

			Integer numberOfWaysFragmentCanBeDecoded = variants.get(subMessage);

			if (numberOfWaysFragmentCanBeDecoded != null && numberOfWaysFragmentCanBeDecoded == 0) {
				return 0;
			} else if (numberOfWaysFragmentCanBeDecoded != null) {
				result *= numberOfWaysFragmentCanBeDecoded;
			} else {
				// generate all triplets
				int sum = 0;
				var alltriplets = getAllTriplets(subMessage);

				// System.out.println(alltriplets);
				for (var subtriplet : alltriplets) {
					sum += numberOfWaysTheMessageCanBeDecoded(subtriplet);
				}

				
				System.out.println("'" + subMessage + "'<-" + sum);
				variants.put(subMessage, sum);
				return sum;
			}
		}
		printTriplet(triplet, result);
		//System.out.println("***" + triplet.getStringList() + "=" + result);
		return result;
	}
	
	private void printTriplet(Triplet triplet, int numvariants) {
		for (var word: triplet.getStringList()) {Integer numVariants = variants.get(word);
			if (word.length()==0) {
				word="0";
				numVariants=1;
			}
			
			System.out.print(word + "/");
		}
		System.out.println(" = "+numvariants);
	}

	public int numberOfWaysTheMessageCanBeDecoded(String message) {
		Triplet triplet = new Triplet("", message, "");
		return numberOfWaysTheMessageCanBeDecoded(triplet);
	}

	public static void main(String... args) {
		App app = new App();
		System.out.println(app.variants);
		String message = "123456789";
		int result = app.numberOfWaysTheMessageCanBeDecoded(message);
		System.out.println("Number of ways the message can be decoded: " + result);
	}

}
