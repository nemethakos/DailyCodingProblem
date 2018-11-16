package Problem78;

import java.util.List;

/**
 * Given k sorted singly linked lists, write a function to merge all the lists
 * into one sorted singly linked list.
 */
public class Problem78 {

	/**
	 * <p>
	 * Compares two values: a with b.
	 * <ul>
	 * <li>if a < b returns a negative integer
	 * <li>if a == b returns 0
	 * <li>if a > b returns a positive integer
	 * </ul>
	 * 
	 * @param <T> the type of the values
	 */
	@FunctionalInterface
	public interface Compare<T> {
		int compare(T a, T b);
	}

	/**
	 * Singly linked list node type
	 * 
	 * @param <T> the type of value
	 */
	public static class Node<T> {
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

	}

	/**
	 * Merges the linked lists into one list
	 * 
	 * @param sortedLists the {@link List} of {@link Node}s
	 * @return the merged lists
	 */
	public static <T> Node<T> merge(List<Node<T>> sortedLists, Compare<T> compare) {

		Node<T> result = null;

		if (sortedLists != null && sortedLists.size() > 0) {

			while (sortedLists.size() > 1) {
				var list1 = sortedLists.remove(0);
				var list2 = sortedLists.remove(0);

				Node<T> mergedLists = mergeTwoLists(list1, list2, compare);

				sortedLists.add(mergedLists);
			}

			result = sortedLists.remove(0);
		}

		return result;
	}

	private static <T> Node<T> mergeTwoLists(Node<T> list1, Node<T> list2, Compare<T> compare) {
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
				resultTail = appendOne(node1, resultTail);
				resultTail = appendOne(node2, resultTail);
			}
			// list1.value < list2.value
			else if (compareResult < 0) {
				var node1 = list1;
				list1 = list1.next;
				resultTail = appendOne(node1, resultTail);
			// list2.value < list1.value
			} else {
				var node2 = list2;
				list2 = list2.next;
				resultTail = appendOne(node2, resultTail);
			}
		}

		if (list1 == null) {
			resultTail = append(list2, resultTail);
		} else if (list2 == null) {
			resultTail = append(list1, resultTail);
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
	private static <T> Node<T> appendOne(Node<T> node, Node<T> tail) {
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
	private static <T> Node<T> append(Node<T> head, Node<T> tail) {
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
