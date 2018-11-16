package Problem78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import Problem78.Problem78.Node;

class Problem78Test {

	private static final int LENGTH_OF_LIST = 10;
	private static final int NUMBER_OF_LISTS = 100;

	Node<Integer> getList(int from, int count, int delta) {
		int value = from;
		Node<Integer> head = new Node<>(value);
		var node = head;
		for (var i = 1; i < count; i++) {
			value += delta;
			node.next = new Node<Integer>(value);
			node = node.next;
		}

		return head;
	}

	List<Node<Integer>> getLists(int numLists) {
		List<Node<Integer>> result = new ArrayList<>();

		for (var i = 1; i <= numLists; i++) {
			result.add(getList((numLists + i) * i, LENGTH_OF_LIST, i));
		}

		return result;
	}

	void putAllValueToMap(Map<Integer, Integer> map, Node<Integer> list) {
		while (list != null) {
			if (map.get(list.value) == null) {
				map.put(list.value, 1);
			} else {
				map.put(list.value, map.get(list.value) + 1);
			}
			list = list.next;
		}
	}

	boolean hasAllValues(List<Node<Integer>> lists, Node<Integer> merged) {
		var result = false;

		Map<Integer, Integer> mapOriginal = new HashMap<>();
		for (var list : lists) {
			putAllValueToMap(mapOriginal, list);
		}

		Map<Integer, Integer> mapMerged = new HashMap<>();
		putAllValueToMap(mapMerged, merged);

		result = mapOriginal.equals(mapMerged);

		return result;
	}

	boolean isOrdered(Node<Integer> head) {
		var result = true;
		Node<Integer> prev = head;
		head = head.next;
		while (head != null) {
			if (prev.value > head.value) {
				result = false;
				break;
			}
			prev = head;
			head = head.next;
		}
		return result;
	}

	@Test
	void testMerge() {

		var lists = getLists(NUMBER_OF_LISTS);
		// the lists will be destroyed after the merge, so we need the same list of
		// linked lists for checking
		var originalLists = getLists(NUMBER_OF_LISTS);

		var merged = Problem78.merge(lists, (a, b) -> a.intValue() - b.intValue());
		// check if all values in the list of linked lists are present in the merged
		// list
		assertTrue(hasAllValues(originalLists, merged));

		// check if the merged list is in order
		assertTrue(isOrdered(merged));
	}

}
