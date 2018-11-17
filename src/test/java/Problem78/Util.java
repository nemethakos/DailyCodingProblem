package Problem78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

	public static boolean isOrdered(Node<Integer> head) {
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

	public static boolean hasAllValues(List<Node<Integer>> lists, Node<Integer> merged) {
		var result = false;
	
		Map<Integer, Integer> mapOriginal = new HashMap<>();
		for (var list : lists) {
			Util.putAllValueToMap(mapOriginal, list);
		}
	
		Map<Integer, Integer> mapMerged = new HashMap<>();
		Util.putAllValueToMap(mapMerged, merged);
	
		result = mapOriginal.equals(mapMerged);
	
		return result;
	}

	public static void putAllValueToMap(Map<Integer, Integer> map, Node<Integer> list) {
		while (list != null) {
			if (map.get(list.value) == null) {
				map.put(list.value, 1);
			} else {
				map.put(list.value, map.get(list.value) + 1);
			}
			list = list.next;
		}
	}

	public static List<Node<Integer>> getLists(int numLists, int listLength) {
		List<Node<Integer>> result = new ArrayList<>();
	
		for (var i = 1; i <= numLists; i++) {
			result.add(Util.getList((numLists + i) * i, listLength, i));
		}
	
		return result;
	}

	public static Node<Integer> getList(int from, int count, int delta) {
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

}
