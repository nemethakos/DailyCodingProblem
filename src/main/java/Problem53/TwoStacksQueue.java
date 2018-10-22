package Problem53;

import java.util.Stack;

/**
 * Implement a queue using two stacks. Recall that a queue is a FIFO (first-in,
 * first-out) data structure with the following methods:
 * <ul>
 * <li>enqueue, which inserts an element into the queue, and
 * <li>dequeue, which removes it.
 * </ul>
 */
public class TwoStacksQueue<T> {

	Stack<T> stack = new Stack<>();

	public void enqueue(T item) {
		stack.add(item);
	}

	public T dequeue() {
		Stack<T> tmp = new Stack<>();
		while (!stack.empty()) {
			tmp.push(stack.pop());
		}

		T last = tmp.pop();

		while (!tmp.empty()) {
			stack.push(tmp.pop());
		}

		return last;

	}

	public T peek() {
		Stack<T> tmp = new Stack<>();
		while (!stack.empty()) {
			tmp.push(stack.pop());
		}

		T last = tmp.peek();

		while (!tmp.empty()) {
			stack.push(tmp.pop());
		}

		return last;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
