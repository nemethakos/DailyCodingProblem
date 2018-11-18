package data.binarytree;

/**
 * Binary Tree Node for int value
 */
public class BinaryTreeNode {

	private BinaryTreeNode parent;
	
	public BinaryTreeNode getParent() {
		return parent;
	}
	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}

	private BinaryTreeNode left;

	private BinaryTreeNode right;

	private int value;

	private BinaryTreeNode(Builder builder) {
		this.parent = builder.parent;
		this.left = builder.left;
		this.right = builder.right;
		this.value = builder.value;
	}

	public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public int getValue() {
		return value;
	}

	public boolean isLeaf() {
		return left == null & right == null;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return BinaryTreePrinter.getNodeAsString(this);
	}
	/**
	 * Creates builder to build {@link BinaryTreeNode}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link BinaryTreeNode}.
	 */
	public static final class Builder {
		private BinaryTreeNode parent;
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		private int value;

		private Builder() {
		}

		public Builder withParent(BinaryTreeNode parent) {
			this.parent = parent;
			return this;
		}

		public Builder withLeft(BinaryTreeNode left) {
			this.left = left;
			return this;
		}

		public Builder withRight(BinaryTreeNode right) {
			this.right = right;
			return this;
		}

		public Builder withValue(int value) {
			this.value = value;
			return this;
		}

		public BinaryTreeNode build() {
			return new BinaryTreeNode(this);
		}
	}

}
