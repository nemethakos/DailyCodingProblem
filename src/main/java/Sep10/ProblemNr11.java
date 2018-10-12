package Sep10;

import java.util.Arrays;

public class ProblemNr11 {

	private static final String[] wordList = {"abba", "baba", "dog", "deer", "deal", "deutschland"};

	public static void main(String... args) {
		Node root = new Node();
		root.addWordList(Arrays.asList(wordList));
		System.out.println(root.toString2());
		System.out.println(root.autoCompleteList("de"));
	}
}
