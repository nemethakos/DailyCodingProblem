package data.binarytree;

import java.util.Arrays;

/**
 * Encapsulates a Binary Tree
 */
public class BinaryTree {
	private BinaryTreeNode head;

	/**
	 * Finds the {@link BinaryTreeNode} containing the provided value in the binary
	 * tree, if it is a binary search tree
	 * 
	 * @param value the value to search for
	 * @return null if the node is not found, the {@link BinaryTreeNode} containing
	 *         the value otherwise
	 */
	public BinaryTreeNode findOneNodeByValue(int value) {
		return findNodeByValue(head, value);
	}

	/**
	 * Finds the value in the subtree represented by {@code root}
	 * 
	 * @param root  the head of subtree to search in
	 * @param value the value to search for
	 * @return the {@link BinaryTreeNode} containing the value or null if not found.
	 */
	private BinaryTreeNode findNodeByValue(BinaryTreeNode root, int value) {
		if (root == null) {
			return null;
		} else {
			int rootValue = root.getValue();
			BinaryTreeNode nextRoot; 
			if (rootValue == value) {
				return root;
			} else if (value < rootValue) {
				nextRoot = root.getLeft();
			} else {
				nextRoot = root.getRight();
			}
			return findNodeByValue(nextRoot, value);
		}
	}

	/**
	 * Creates a new {@link BinaryTree} initialized with the head of the given tree.
	 * 
	 * @param head the {@link BinaryTreeNode}
	 * @return the new {@link BinaryTree}
	 */
	public static BinaryTree from(BinaryTreeNode head) {
		return new BinaryTree(head);

	}

	/**
	 * Constructor
	 */
	public BinaryTree(BinaryTreeNode head) {
		super();
		this.head = head;
	}

	public BinaryTreeNode getHead() {
		return head;
	}

	private void inorderTraversal(BinaryTreeNode node, BinaryTreeNodeVisitor visitor, int level) {
		if (node == null) {
			return;
		} else {
			inorderTraversal(node.getLeft(), visitor, level + 1);
			visitor.visit(node, level);
			inorderTraversal(node.getRight(), visitor, level + 1);
		}

	}

	private void postorderTraversal(BinaryTreeNode node, BinaryTreeNodeVisitor visitor, int level) {
		if (node == null) {
			return;
		} else {
			visitor.visit(node, level);
			postorderTraversal(node.getLeft(), visitor, level + 1);
			postorderTraversal(node.getRight(), visitor, level + 1);
		}

	}

	private void preorderTraversal(BinaryTreeNode node, BinaryTreeNodeVisitor visitor, int level) {
		if (node == null) {
			return;
		} else {
			preorderTraversal(node.getLeft(), visitor, level + 1);
			preorderTraversal(node.getRight(), visitor, level + 1);
			visitor.visit(node, level);
		}

	}

	public void setHead(BinaryTreeNode head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return String.format("%s", head);
	}

	/**
	 * Visits all node using the {@link TraversalType} and the
	 * {@link BinaryTreeNodeVisitor} functional interface
	 * 
	 * @param visitor       the {@link BinaryTreeNodeVisitor}'s
	 *                      {@link BinaryTreeNodeVisitor#visit(BinaryTreeNode, int)}
	 *                      method is called for every visited node.
	 * @param traversalType the type of tree traversal used {@link TraversalType}
	 */
	public void visitNodes(BinaryTreeNodeVisitor visitor, TraversalType traversalType) {
		if (traversalType.equals(TraversalType.DEPTH_FIRST_SEARCH_INORDER)) {
			inorderTraversal(head, visitor, 0);
		} else if (traversalType.equals(TraversalType.DEPTH_FIRST_SEARCH_PREORDER)) {
			preorderTraversal(head, visitor, 0);
		} else if (traversalType.equals(TraversalType.DEPTH_FIRST_SEARCH_POSTORDER)) {
			postorderTraversal(head, visitor, 0);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Creates a binary Tree from the array elements.
	 * 
	 * @param array     the int array
	 * @param lowIndex  the starting index to be used for build the tree
	 * @param highIndex the end index to be used to build the tree
	 * @param parent    the parent
	 * @return the tree
	 */
	protected static BinaryTreeNode getBinaryTreeFrom(int[] array, int lowIndex, int highIndex, BinaryTreeNode parent) {

		if (lowIndex > highIndex) {
			return null;
		}

		int medianIndex = (highIndex + lowIndex) / 2;

		int nodeValue = array[medianIndex];

		BinaryTreeNode parentNode = new BinaryTreeNode(nodeValue);
		parentNode.setParent(parent);

		BinaryTreeNode left = getBinaryTreeFrom(array, lowIndex, medianIndex - 1, parentNode);
		parentNode.setLeft(left);

		BinaryTreeNode right = getBinaryTreeFrom(array, medianIndex + 1, highIndex, parentNode);
		parentNode.setRight(right);

		return parentNode;

	}

	/**
	 * Returns a binary tree using the array elements. The arrays can be unsorted.
	 * 
	 * @param array the array for the binary tree
	 * @return the {@link BinaryTree} made from the array
	 */
	public static BinaryTree fromArray(int... array) {
		Arrays.sort(array);
		var head = getBinaryTreeFrom(array, 0, array.length - 1, null);
		return BinaryTree.from(head);
	}

}
