package data.binarytree;

@FunctionalInterface
/**
 * Functional interface for visiting {@link BinaryTree} nodes
 */
public interface BinaryTreeNodeVisitor {
	/**
	 * Called when a node at level {@code level} is visited at the binary tree
	 * 
	 * @param node  the {@link BinaryTreeNode}
	 * @param level the depth of the node (0: the root node)
	 * @return false if the traversal should be stopped, true if should be continued
	 */
	public boolean visit(BinaryTreeNode node, int level);
}
