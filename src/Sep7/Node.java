package Sep7;

public class Node {

	public boolean hasChildren() {
		return left != null && right != null;
	}

	private Node left;
	private Node right;
	private int value;

	public Node(int value, Node left, Node right) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public Node(int value) {
		super();
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public int getValue() {
		return value;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return print("", this, false).toString();
	}

	public void print() {
		print("", this, false);
	}

	public StringBuilder print(String prefix, Node n, boolean isLeft) {
		StringBuilder sb = new StringBuilder();
		
		if (n != null) {
			sb.append(prefix + (isLeft ? "|-- " : "\\-- ") + n.value + "\r\n");
			sb.append(print(prefix + (isLeft ? "|   " : "    "), n.left, true));
			sb.append(print(prefix + (isLeft ? "|   " : "    "), n.right, false));
		}

		return sb;
	}

}
