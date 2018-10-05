package datatypes;

/**
 * Generic binary tree node type
 *
 * @param <T> The value type for nodes
 */
public class Node<T> {

	private Node<T> left;
	private Node<T> right;
	private T value;

	public Node(T value) {
		super();
		this.value = value;
	}

	public Node(T value, Node<T> left, Node<T> right) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public T getValue() {
		return value;
	}

	public boolean hasAnyChild() {
		return left != null || right != null;
	}
	
	public boolean hasBothChildren() {
		return left != null && right != null;
	}

	public void print() {
		print("", this, false);
	}

	public StringBuilder print(String prefix, Node<T> n, boolean isLeft) {
		StringBuilder sb = new StringBuilder();

		if (n != null) {
			sb.append(prefix + (isLeft ? "|-- " : "\\-- ") + n.value + "\r\n");
			sb.append(print(prefix + (isLeft ? "|   " : "    "), n.left, true));
			sb.append(print(prefix + (isLeft ? "|   " : "    "), n.right, false));
		}

		return sb;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		//return print("", this, false).toString();
		return this.getValue().toString();
	}

}
