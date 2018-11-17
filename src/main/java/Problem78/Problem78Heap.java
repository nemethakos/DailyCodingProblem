package Problem78;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given k sorted singly linked lists, write a function to merge all the lists
 * into one sorted singly linked list.
 */
public class Problem78Heap {
	/**
	 * Merges the linked lists into one list
	 * 
	 * @param sortedLists the {@link List} of {@link Node}s
	 * @return the merged lists
	 */
	public static <T> Node<T> merge(List<Node<T>> sortedLists, Comparator<Node<T>> comparator) {

		PriorityQueue<Node<T>> queue = new PriorityQueue<>(comparator);
		for (var node : sortedLists) {
			while (node != null) {
				queue.add(node);
				node = node.next;
			}
		}

		// dummy head
		Node<T> head = new Node<T>(null);
		Node<T> tail = head;

		while (!queue.isEmpty()) {
			Node<T> node = queue.remove();
			Node.appendOne(node, tail);
			tail = tail.next;
		}

		// skip dummy head
		return head.next;
	}

}
