package datatypes;

public class DoubleLinkedList<K, V> {

	ListNode<K, V> head;
	ListNode<K, V> tail;

	public DoubleLinkedList() {
		super();

		// head guard
		head = new ListNode<K, V>(null,null);
		// tail guard
		tail = new ListNode<K, V>(null,null);

		head.setNext(tail);
		tail.setPrev(head);
	}

	public ListNode<K, V> remove(ListNode<K, V> node) {
 
		var prev = node.getPrev();
		var next = node.getNext();
		
		prev.setNext(next);
		next.setPrev(prev);
		
		
		return node;
	}

	public void addToHead(ListNode<K, V> node) {
		var oldFirst = head.getNext(); 
		
		node.setNext(head.getNext());
		node.setPrev(head);
		
		head.setNext(node);
		
		oldFirst.setPrev(node);
	}

	public ListNode<K, V> removeFromTail() {
		return remove(tail.getPrev());
	}

}
