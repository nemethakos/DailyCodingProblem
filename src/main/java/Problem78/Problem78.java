package Problem78;

import java.util.List;

import static Problem78.Node.mergeTwoLists;

/**
 * Given k sorted singly linked lists, write a function to merge all the lists
 * into one sorted singly linked list.
 */
public class Problem78 {

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

	

}
