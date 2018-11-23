package Problem11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	private Map<Character, Node> map = new HashMap<>();

	private boolean isTerminal() {
		return map.isEmpty();
	}

	@Override
	public String toString() {
		return "Node [map=" + map + "]";
	}

	public String toString2() {
		var sb = new StringBuilder();
		toString(this, sb, 0, "");
		return sb.toString();
	}

	public void toString(Node node, StringBuilder sb, int level, String word) {


		if (node != null) {
			if (node.isTerminal()) {
				sb.append(getNSpaces(level, " ") + "[" + word + "]\r\n");
			}
			Character[] i = node.getMap().keySet().toArray(new Character[0]);

			for (Character c : i) {

				sb.append(getNSpaces(level, " "));
				sb.append(c);
				sb.append("\r\n");

				Node childNode = node.getMap().get(c);

				toString(childNode, sb, level + 1, word + c);

			}

		}
	}

	private String getNSpaces(int level, String space) {
		return String.join("", Collections.nCopies(level * 2, space));
	}

	public void addWord(String text) {
		Node currentNode = this;
		for (int i = 0; i < text.length(); i++) {
			var currentChar = text.charAt(i);
			var nextNode = currentNode.getMap().get(currentChar);
			if (nextNode == null) {
				nextNode = new Node();
				currentNode.getMap().put(currentChar, nextNode);
			}
			currentNode = nextNode;
		}
	}

	public void addWordList(List<String> wordList) {
		wordList.stream().forEach(word -> {
			addWord(word);
		});
	}

	public Map<Character, Node> getMap() {
		return map;
	}

	public List<String> autoCompleteList(String text) {
		List<String> result = new ArrayList<>();

		Node current = this;

		for (int i = 0; i < text.length(); i++) {
			var chr = text.charAt(i);

			var nextNode = current.getMap().get(chr);
			if (nextNode == null) {
				return result;
			}
			current = nextNode;
		}
		// from current node every combination is returned
		StringBuilder path = new StringBuilder(text);

		collectWords(current, result, path);

		return result;
	}

	private void collectWords(Node current, List<String> result, StringBuilder path) {
		if (current == null) {
			return;
		} else if (current.isTerminal()) {
			result.add(path.toString());
		} else {
			current.getMap().keySet().stream().forEach(key -> {
				StringBuilder sb = new StringBuilder(path);
				sb.append(key);
				collectWords(current.getMap().get(key), result, sb);
			});
		}

	}

}
