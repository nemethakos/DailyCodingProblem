package Problem20;

public class Element {

	private int value;
	private Element next;

	public Element getNext() {
		return next;
	}

	public Element skip(int numberOfElementsToSkip) {
		Element e = this;
		while (e != null && numberOfElementsToSkip > 0) {
			e = e.next;
			numberOfElementsToSkip--;
		}

		return e;
	}

	public int length() {

		int len = 0;

		Element e = this;

		while (e != null) {
			e = e.next;
			len++;
		}

		return len;
	}

	private Element end() {
		Element e = this;

		while (e.next != null) {
			e = e.next;
		}

		return e;
	}

	public Element(int value) {
		super();
		this.value = value;
	}

	public Element add(Element e) {
		end().next = e;
		return this;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		Element e = this;
		do {
			sb.append(e.getValue() + ", ");
			e = e.next;
		} while (e != null);

		sb.delete(sb.length() - 2, sb.length() - 1);

		return sb.toString();
	}

	public int getValue() {
		return value;
	}

}
