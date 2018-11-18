package data.binarytree;

public class BinaryTreeDepth {

	private int leftDepth;
	private int rightDepth;

	public BinaryTreeDepth(int leftDepth, int rightDepth) {
		super();
		this.leftDepth = leftDepth;
		this.rightDepth = rightDepth;
	}

	public int getLeftDepth() {
		return leftDepth;
	}

	public int getRightDepth() {
		return rightDepth;
	}

	public boolean isBalanced() {
		return Math.abs(leftDepth - rightDepth) < 1;
	}

	public int max() {
		return Math.max(leftDepth, rightDepth);
	}

	public void setLeftDepth(int leftDepth) {
		this.leftDepth = leftDepth;
	}
	public void setRightDepth(int rightDepth) {
		this.rightDepth = rightDepth;
	}

	@Override
	public String toString() {
		return String.format("BinaryTreeDepth [leftDepth=%s, rightDepth=%s]", leftDepth, rightDepth);
	}

}
