package Problem43;

public class StackElement {

	public static StackElement build(int value, int max) {
		return new StackElement(value, max);
	}

	private StackElement(int value, int max) {
		super();
		this.value = value;
		this.max = max;
	}

	private int value;
	private int max;

	public int getValue() {
		return value;
	}

	public int getMax() {
		return max;
	}

	@Override
	public String toString() {
		return String.format("StackElement [value=%s, max=%s]", value, max);
	}
}
