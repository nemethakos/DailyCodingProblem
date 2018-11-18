package Problem80;

import data.binarytree.BinaryTree;
import data.binarytree.BinaryTreeNode;

/**
 * <p>
 * Given the root of a binary tree, return a deepest node. For example, in the
 * following tree, return d.
 * 
 * <pre>
    a
   / \
  b   c
 /
d
 * </pre>
 */
public class Problem80 {

	/**
	 * Class for holding the {@link BinaryTreeNode} and its depth.
	 */
	private static class DeepestNode {
		int level;
		BinaryTreeNode binaryTreeNode;

		public DeepestNode(BinaryTreeNode btn, int level) {
			super();
			this.level = level;
			this.binaryTreeNode = btn;
		}
	}

	/**
	 * Returns the deepest node chosen from the left or right child
	 * 
	 * @param binaryTreeNode the parent node
	 * @param level          the level of the parent node
	 * @return the deepest node chosen from the left or right child
	 */
	public static DeepestNode breadthFirstSearch(BinaryTreeNode binaryTreeNode, int level) {

		// base case: leaf node
		if (binaryTreeNode.isLeaf()) {
			return new DeepestNode(binaryTreeNode, level);
		}

		// dummy left and right nodes in case there is no right and/or left node
		DeepestNode left = new DeepestNode(null, 0);
		DeepestNode right = new DeepestNode(null, 0);

		// get the right child's deepest node
		if (binaryTreeNode.getRight() != null) {
			right = breadthFirstSearch(binaryTreeNode.getRight(), level + 1);
		}

		// get the left child's deepest node
		if (binaryTreeNode.getLeft() != null) {
			left = breadthFirstSearch(binaryTreeNode.getLeft(), level + 1);
		}

		// decide which is deeper
		if (left.level > right.level) {
			return left;
		} else {
			return right;
		}
	}

	/**
	 * Returns the deepest node's value from the {@link BinaryTree}
	 * 
	 * @param tree the {@link BinaryTree}
	 * @return the value of the deepest node
	 */
	public static BinaryTreeNode getDeepestNode(BinaryTree tree) {

		// safety check
		if (tree == null || tree.getHead() == null) {
			return null;
		} else {
			return breadthFirstSearch(tree.getHead(), 0).binaryTreeNode;
		}
	}

}
