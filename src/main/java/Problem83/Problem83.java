package Problem83;

import data.binarytree.BinaryTree;
import data.binarytree.BinaryTreeNode;

/**
 * <p>
 * Invert a binary tree.
 * 
 * <p>
 * For example, given the following tree:
 * 
 * <pre>
    a
   / \
  b   c
 / \  /
d   e f
 * </pre>
 * <p>
 * should become:
 * 
 * <pre>
  a
 / \
 c  b
 \  / \
  f e  d
 * </pre>
 */
public class Problem83 {

	/**
	 * Inverts the tree. The original tree will be modified and returned.
	 * 
	 * @param tree the {@link BinaryTree}
	 * @return the inverted tree
	 */
	public static BinaryTree invert(BinaryTree tree) {

		invert(tree.getHead());

		return tree;
	}

	/**
	 * Recursively inverts the tree (BFS)
	 * 
	 * @param head the head of the tree
	 */
	private static void invert(BinaryTreeNode head) {
		if (head == null || head.isLeaf()) {
			return;
		}

		invert(head.getLeft());
		invert(head.getRight());

		BinaryTreeNode left = head.getLeft();
		BinaryTreeNode right = head.getRight();

		head.setLeft(right);
		head.setRight(left);
	}
}
