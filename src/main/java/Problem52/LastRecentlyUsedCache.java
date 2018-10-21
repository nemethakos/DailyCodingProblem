package Problem52;

import java.util.HashMap;

import datatypes.DoubleLinkedList;
import datatypes.ListNode;

/**
 * <p>
 * Implement an LRU (Least Recently Used) cache. It should be able to be
 * initialized with a cache size n, and contain the following methods:
 * 
 * <ul>
 * <li>{@code set(key, value):} sets key to value. If there are already n items
 * in the cache and we are adding a new item, then it should also remove the
 * least recently used item.
 * <li>{@code get(key):} gets the value at key. If no such key exists, return
 * null.
 * </ul>
 * <p>
 * Each operation should run in O(1) time.
 *
 */
public class LastRecentlyUsedCache<K, V> {
	private int maxElements;

	private HashMap<K, ListNode<K, V>> map = new HashMap<>();

	private DoubleLinkedList<K, V> linkedList = new DoubleLinkedList<K, V>();

	public LastRecentlyUsedCache(int maxElements) {
		super();
		this.maxElements = maxElements;
	}

	@Override
	public String toString() {
		return String.format("LastRecentlyUsedCache [mapsize=%d, maxElements=%s, map=%s]", map.size(), maxElements, map);
	}

	public void set(K key, V value) {
		var node = map.get(key);
		// node exists
		if (node != null) {
			node.setValue(value);
			moveToFirst(node);
		} else {
			// node does not exists
			if (maxElements == map.size()) {
				removeLastNode();
			}
			ListNode<K, V> newNode = new ListNode<K, V>(key, value);
			linkedList.addToHead(newNode);
			map.put(key, newNode);
		}
	}

	private void removeLastNode() {
		// remove last node
		var removed = linkedList.removeFromTail();
		map.remove(removed.getKey());
	}

	private void moveToFirst(ListNode<K, V> node) {
		linkedList.remove(node);
		linkedList.addToHead(node);
	}

	public V get(K key) {
		var node = map.get(key);
		V value = null;
		if (node != null) {
			moveToFirst(node);
			value = node.getValue();
		}
		return value;
	}
}
