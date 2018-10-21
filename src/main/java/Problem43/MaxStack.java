package Problem43;

import java.util.Stack;

public class MaxStack {

	private int currentMax = Integer.MIN_VALUE;
	private Stack<StackElement> stack = new Stack<>();

	private void updateMax(int value) {
		if (value > currentMax) {
			currentMax = value;
		}
	}

	public void push(int value) {
		updateMax(value);
		stack.push(StackElement.build(value, currentMax));
	}

	public int pop() {
		checkIfStackIsNonEmpty();
		var stackElement = stack.pop();
		currentMax = stackElement.getMax();
		return stackElement.getValue();
	}

	private void checkIfStackIsNonEmpty() {
		if (stack.size() == 0)
			throw new EmptyStackException();
	}

	public int max() {
		checkIfStackIsNonEmpty();
		return currentMax;
	}

}
