package Problem36;

import java.util.ArrayList;
import java.util.logging.Logger;

import datatypes.Node;

/**
 * <p>
 * <b>Problem:</b>Given the root to a binary search tree, find the second largest node in the
 * tree.
 * <p>
 * <b>Note:</b> The "official" solution is to do a reverse in-order traversal
 * and count the number of nodes processed. When the second node is processed,
 * it is the result.
 * <p>
 * <b>Possible official Java solution:</b><a href=
 * "https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/">https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/</a>
 */
public class Pr36 {

	public static final Logger LOG = Logger.getLogger(Pr36.class.getName());

	public Node<Integer> getSecondLargestNode(Node<Integer> root) {

		var currentNode = root;
		var largestNodesList = new ArrayList<Node<Integer>>();
		largestNodesList.add(currentNode);

		while (currentNode.hasAnyChild()) {

			if (currentNode.getRight() != null) {
				currentNode = currentNode.getRight();
			} else {
				currentNode = currentNode.getLeft();
			}
			LOG.info("Current node: " + currentNode.getValue());
			// update largest list
			if (currentNode.getValue() > largestNodesList.get(0).getValue()) {
				// current node has the largest value
				largestNodesList.add(0, currentNode);
			} else if (largestNodesList.size() == 1 && //
					currentNode.getValue() < largestNodesList.get(0).getValue()) {
				// only one node in the list and second largest value
				largestNodesList.add(1, currentNode);
			} else if (largestNodesList.size() > 1 && //
					currentNode.getValue() > largestNodesList.get(1).getValue()) {
				// two nodes in the list, current node is greater then second largest
				largestNodesList.add(1, currentNode);

			}

			if (largestNodesList.size() > 2) {
				largestNodesList.remove(2);
			}
			LOG.info("List: " + largestNodesList);
		}

		return largestNodesList.get(largestNodesList.size() - 1);
	}

	public static void main(String[] args) {
		Node<Integer> tree = new Node<Integer>(100, //
				new Node<Integer>(50), //
				new Node<Integer>(200, //
						new Node<Integer>(150), //
						new Node<Integer>(400, //
								new Node<Integer>(350, //
										new Node<Integer>(300, //
												new Node<Integer>(250), //
												new Node<Integer>(325)), //
										null//
								), //

								null)//
				)//
		);
		Pr36 app = new Pr36();
		// complex tree
		System.out.println("Complex tree: " + app.getSecondLargestNode(tree).getValue());

		// single node
		System.out.println("Single node: " + app.getSecondLargestNode(new Node<Integer>(100)).getValue());

		// one left child
		System.out.println("Only left child: " + //
				app//
						.getSecondLargestNode(//
								new Node<Integer>(100, //
										new Node<Integer>(50), //
										null))//
						.getValue());

		// one right child
		System.out.println("Only right child: " + //
				app//
						.getSecondLargestNode(//
								new Node<Integer>(100, //
										null, new Node<Integer>(200)))//
						.getValue());

	}

}
