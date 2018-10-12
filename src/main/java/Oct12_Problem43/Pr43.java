package Oct12_Problem43;

/**
 * <p>
 * Implement a stack that has the following methods:
 * <ul>
 * <li>push(val), which pushes an element onto the stack
 * <li>pop(), which pops off and returns the topmost element of the stack. If
 * there are no elements in the stack, then it should throw an error or return
 * null.
 * <li><b>max()</b>, which returns the <b>maximum value</b> in the stack
 * currently. If there are no elements in the stack, then it should throw an
 * error or return null.
 * </ul>
 * <p>
 * Each method should <em>run in constant time<em>.
 */
public class Pr43 {

	public static void main(String[] args) {

		var maxStack = new MaxStack();
		for (var i = 0; i <= 100; i++) {
			maxStack.push(i);
		}
		for (var i = 1000; i >= 0; i-=100) {
			maxStack.push(i);
		}
		System.out.println("Max: " + maxStack.max());
		for (var i = 0; i < 1000; i++) {

			System.out.println("max: " + maxStack.max() + ", pop:" + maxStack.pop());

		}

	}

}
