package datatypes;

public class ListNode<K,T> {

	private K key;
	private ListNode<K,T> next;
	private ListNode<K,T> prev;
	private T value;

	public ListNode(K key, T value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public ListNode<K,T> getNext() {
		return next;
	}

	public ListNode<K,T> getPrev() {
		return prev;
	}

	public T getValue() {
		return value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setNext(ListNode<K,T> next) {
		this.next = next;
	}

	public void setPrev(ListNode<K,T> prev) {
		this.prev = prev;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("ListNode [key=%s, value=%s]", key, value);
	}

}
