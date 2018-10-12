package Sep7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {

	private Set<Integer> getChildValueSet(Node node) {

		var result = new HashSet<Integer>();

		if (node != null) {
			result.add(node.getValue());
			if (node.hasChildren()) {
				result.addAll(getChildValueSet(node.getLeft()));
				result.addAll(getChildValueSet(node.getRight()));
			}
		}

		return result;
	}

	private int countTheNumberOfUniversalSubTrees(Node node) {
		if (node == null) {
			return 0; // null node
		} else if (!node.hasChildren()) {
			return 1; // single root
		} else {
			var nodeSet = new HashSet<Integer>(Arrays.asList(node.getValue()));
			var leftSet = getChildValueSet(node.getLeft()); // left values
			var rightSet = getChildValueSet(node.getRight()); // right values

			boolean leftEquals = nodeSet.equals(leftSet);
			boolean rightEquals = nodeSet.equals(rightSet);
			boolean bothEquals = leftEquals && rightEquals;
			
			int numberOfUniversalValueTrees = 1;

			if (!bothEquals) {

				numberOfUniversalValueTrees += countTheNumberOfUniversalSubTrees(node.getLeft());
				numberOfUniversalValueTrees += countTheNumberOfUniversalSubTrees(node.getRight());

			}
			return numberOfUniversalValueTrees;

		}
	}

	private Node getTree() {

		Node root = new Node(0, new Node(1), new Node(0, new Node(1, new Node(1), new Node(1)), new Node(0)));

		return root;
	}

	public static void main(String... args) {
		App app = new App();

		var set = app.getChildValueSet(app.getTree());
		var count = app.countTheNumberOfUniversalSubTrees(app.getTree());
		System.out.println("Number of universal trees: " + count);
	}

}
