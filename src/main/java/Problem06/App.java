package Problem06;

/**
 * An XOR linked list is a more memory efficient doubly linked list. Instead of
 * each node holding next and prev fields, it holds a field named both, which is
 * an XOR of the next node and the previous node. Implement an XOR linked list;
 * it has an add(element) which adds the element to the end, and a get(index)
 * which returns the node at index.
 * 
 * If using a language that has no pointers (such as Python), you can assume you
 * have access to get_pointer and dereference_pointer functions that converts
 * between nodes and memory addresses.
 */
public class App {

	XORLinkedList xorLinkedList = new XORLinkedList();
	private static final int NUM_NODES = 10;

	public static void main(String[] args) {
		App app = new App();

		app.test();

	}

	private void test() {
		System.out.println("Adding " + NUM_NODES + " nodes...");
		for (var i = 0; i < NUM_NODES; i++) {

			xorLinkedList.add(new Node("Node#" + i));
		}

		System.out.println("XOR Linked List: " + xorLinkedList);

		for (var i = 0; i < NUM_NODES; i++) {
			System.out.println("Node " + i + " = " + xorLinkedList.get(i));
		}

	}

}
