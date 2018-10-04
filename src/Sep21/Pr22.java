package Sep21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pr22 {

	private static Node addToTree(Node root, String word) {
		Node n = root;
		for (var i = 0; i < word.length(); i++) {
			boolean last = i == word.length() - 1;
			n = n.addChild(word.charAt(i), last);
		}
		return root;
	}

	private static List<String> rec(List<String> dict, String text) {
		Node root = new Node('_', false);
		for (var word : dict) {
			addToTree(root, word);
		}
		
		List<String> result = new ArrayList<>();
		var i = 0;
		var start = 0;
		var node = root;
		char c;
		while (i < text.length()) {
			
			c = text.charAt(i);

			var child = node.getChild(c);

			if (child == null) {
				
				return null;
				
			} else {
				
				if (child.isTerminal() && child.isLeaf()) {
				
					result.add(text.substring(start, i + 1));
					start = i + 1;
					node = root;
					
				} else {
					node = child;
				}
			}
			
			i++;			
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println(rec(Arrays.asList("the", "theremin"), "theremin"));
		
		//System.out.println(rec(Arrays.asList("bed", "bedbath","bath", "and", "beyond"), "bedbathandbeyond"));
		
		//System.out.println(rec(Arrays.asList("quick", "brown", "the", "fox"), "thequickbrownfox"));
	}

}
