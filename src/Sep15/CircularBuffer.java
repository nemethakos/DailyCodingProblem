package Sep15;

public class CircularBuffer {

	private int[] buffer;
	private int numElements;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < numElements; i++) {
			sb.append(i);
			if (i != numElements - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();

	}

	public CircularBuffer(int maxElements) {
		super();
		this.buffer = new int[maxElements];
		this.numElements = 0;
	}

	/**
	 * Puts an element into the buffer
	 * 
	 * @param orderId the element
	 */
	public void record(int orderId) {
		if (numElements >= buffer.length) {
			throw new IllegalArgumentException("Buffer already full");
		}
		buffer[numElements] = orderId;
		numElements++;
	}

	/**
	 * Returns the ith last element from the buffer
	 */
	public int getLast(int i) {
		if (numElements - 1 - i < 0) {
			throw new IllegalArgumentException("Buffer doesn't have " + (i+1) + " elements!");
		}
		return buffer[numElements - 1 - i];
	}

}
