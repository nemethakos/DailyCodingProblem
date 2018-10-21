package Problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class XORLinkedList {

	@Override
	public String toString() {
		return "XORLinkedList [firstPointer=" + firstPointer + ", nodeHolder=" + nodeHolder + "]";
	}

	private static final int NULL = 0;

	private static final int NUM_DUMMY_NODES = 100;
	
	private Random random = new Random();

	List<Node> nodeHolder = new ArrayList<>();
	int firstPointer = 0;

	public int add(Node newNode) {
		if (firstPointer == NULL) {
			firstPointer = allocateNode(newNode);
			newNode.setBoth(NULL);

			return firstPointer;
		} else {
			Node lastNode = findLastNode();
			int newNodePointer = allocateNode(newNode);
			lastNode.setBoth(lastNode.getBoth() ^ newNodePointer);
			newNode.setBoth(lastNode.getSelfPointer());
			return newNodePointer;
		}
	}

	private int getPointer(Node node) {
		return node.getSelfPointer();
	}

	private Node findLastNode(Node prev, Node node) {

		Node next = null;
		do {
			int nextPointer = node.getBoth() ^ getPointer(prev);
			next = dereferencePointer(nextPointer);
			if (next != null) {
				prev = node;
				node = next;
			}
		} while (next != null);

		return node;
	}

	private Node findLastNode() {
		if (getFirstNode() == null) {
			return null;
		} else {
			if (getFirstNode().getBoth() == NULL) {
				return getFirstNode();
			} else {
				Node first = getFirstNode();
				Node second = getSecondNode();
				return findLastNode(first, second);
			}
		}
	}

	private Node getNextNode(Node prev, Node node) {

		if (prev == null) {
			return node;
		} else {
			int nextPointer = node.getBoth() ^ getPointer(prev);
			return dereferencePointer(nextPointer);
		}
	}

	public Node get(int index) {
		if (index == 0) {
			return getFirstNode();
		} else if (index == 1) {
			int nextPointer = getFirstNode().getBoth();
			return dereferencePointer(nextPointer);
		} else {
			Node next = null;
			Node prev = getFirstNode();
			Node node = dereferencePointer(getFirstNode().getBoth());
			while (index-- > 1) {
				next = getNextNode(prev, node);
				prev = node;
				node = next;
			}
			return node;
		}

	}

	private Node getFirstNode() {
		return nodeHolder.get(firstPointer);
	}

	private Node getSecondNode() {
		if (getFirstNode() == null) {
			return null;
		} else {
			return dereferencePointer(getFirstNode().getBoth());
		}
	}

	private int allocateNode(Node node) {
		addRandomDummyNodes(10);
		var newNodeIndex = nodeHolder.size();
		node.setSelfPointer(newNodeIndex);
		nodeHolder.add(node);

		return newNodeIndex;
	}

	public XORLinkedList() {
		super();
		addDummyNodes(NUM_DUMMY_NODES);
	}

	private void addRandomDummyNodes(int max) {
		addDummyNodes(random.nextInt(max));
	}
	
	private void addDummyNodes(int count) {
		for (var i = 0; i < count; i++) {
			nodeHolder.add(new Node("Dummy Node#"+(i+1)));
		}
	}

	public Node dereferencePointer(int pointer) {
		if (pointer == NULL) {
			return null;
		}
		return nodeHolder.get(pointer);
	}

}
