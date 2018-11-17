package Problem78;

/**
 * Singly linked list node type
 * 
 * @param <T> the type of value
 */
public class Node<T> {
	T value;
	Node<T> next;

	/**
	 * Constructor
	 * 
	 * @param value the value of the node
	 */
	public Node(T value) {
		super();
		this.value = value;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> next = this;
		boolean first = true;
		while (next != null) {
			if (!first) {
				sb.append(" -> ");
			}
			first = false;
			sb.append(next.value);
			next = next.next;
		}

		return sb.toString();
	}
	
	public static <T> Node<T> mergeTwoLists(Node<T> list1, Node<T> list2, Compare<T> compare) {
		// dummy head
		Node<T> resultHead = new Node<>(null);
		Node<T> resultTail = resultHead;
	
		while (list1 != null && list2 != null) {
			var compareResult = compare.compare(list1.value, list2.value);
			// the two values are equal
			if (compareResult == 0) {
				var node1 = list1;
				var node2 = list2;
				list1 = list1.next;
				list2 = list2.next;
				resultTail = Node.appendOne(node1, resultTail);
				resultTail = Node.appendOne(node2, resultTail);
			}
			// list1.value < list2.value
			else if (compareResult < 0) {
				var node1 = list1;
				list1 = list1.next;
				resultTail = Node.appendOne(node1, resultTail);
			// list2.value < list1.value
			} else {
				var node2 = list2;
				list2 = list2.next;
				resultTail = Node.appendOne(node2, resultTail);
			}
		}
	
		if (list1 == null) {
			resultTail = Node.append(list2, resultTail);
		} else if (list2 == null) {
			resultTail = Node.append(list1, resultTail);
		}
	
		// do not include dummy head
		return resultHead.next;
	}

	/**
	 * Appends node to the tail
	 * 
	 * @param node the node to append
	 * @param tail the tail of the list to append to
	 */
	public static <T> Node<T> appendOne(Node<T> node, Node<T> tail) {
		node.next = null;
		tail.next = node;

		return node;
	}

	/**
	 * Appends elements from head in the first list to the tail of the second list
	 * 
	 * @param head the head of the first list
	 * @param tail the tail of the second list
	 */
	public static <T> Node<T> append(Node<T> head, Node<T> tail) {
		if (head != null && tail != null) {
			while (head != null) {
				tail.next = head;
				head = head.next;
				tail = tail.next;
			}
		}
		return tail;
	}

}