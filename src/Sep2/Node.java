package Sep2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;



class Node {

	private Node left;
	private Node right;
	private String value;

	public static final Node NONE = new Node("None", null, null);

	public static Node of(String value) {
		Objects.nonNull(value);

		if (value.length() == 0) {
			throw new IllegalArgumentException("value should be non-empty!");
		}

		return new Node(value, NONE, NONE);

	}

	public static Node of(String value, Node left) {
		Objects.nonNull(value);
		Objects.nonNull(left);

		if (value.length() == 0) {
			throw new IllegalArgumentException("value should be non-empty!");
		}

		return new Node(value, left, NONE);
	}

	public static Node of(String value, Node left, Node right) {
		Objects.nonNull(value);
		Objects.nonNull(left);
		Objects.nonNull(right);

		if (value.length() == 0) {
			throw new IllegalArgumentException("value should be non-empty!");
		}

		return new Node(value, left, right);
	}

	private Node(String value, Node left, Node right) {
		super();

		this.value = value;
		this.left = left;
		this.right = right;
	}

	public static Node deserialize(List<String> elements) {

		String top = elements.remove(0).trim();

		if (top.equals(NONE.getValue())) {
			return NONE;
		}
		else {
			Node left = deserialize(elements);
			Node right = deserialize(elements);
			return Node.of(top, left, right);
		}
	}
	
	public static Node deserialize(String serializedNode) {
		
		List<String> elements = new ArrayList<String>(Arrays.asList(serializedNode.split(",")));
		
		return deserialize(elements);
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public String getValue() {
		return value;
	}

	private String getNCharacters(String characters, int numberOfRepetitions) {
		if (characters.length() == 0 || numberOfRepetitions == 0) {
			return "";
		} else {
			return String.join("", Collections.nCopies(numberOfRepetitions, characters));
		}
	}

	private List<String> serialize(Node node, int depth) {
		List<String> result = new ArrayList<>();

		if (node == null || node.equals(NONE)) {
			result.add(getNCharacters("    ", depth) + NONE.getValue());
		} else {
			result.add(getNCharacters("    ", depth) + node.getValue());
			result.addAll(serialize(node.getLeft(), depth + 1));
			result.addAll(serialize(node.getRight(), depth + 1));
		}

		return result;
	}

	public String serialize() {
		List<String> serialized = new ArrayList<>();

		serialized.addAll(serialize(this, 0));

		return serialized.stream().collect(Collectors.joining(",\r\n"));
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}