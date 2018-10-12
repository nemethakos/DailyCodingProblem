package Sep5;

public class Node {

	String value;
	
	/**
	 * selfpointer represents the "memory address" of the Node, which is the index
	 * in the List
	 */
	int selfPointer;
	
	/**
	 * Both = nextPointer XOR prevPointer
	 */
	int both;




	public Node(String value) {
		super();
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (selfPointer != other.selfPointer)
			return false;
		return true;
	}

	public int getBoth() {
		return both;
	}

	public int getSelfPointer() {
		return selfPointer;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + selfPointer;
		return result;
	}

	public void setBoth(int both) {
		this.both = both;
	}

	public void setSelfPointer(int selfPointer) {
		this.selfPointer = selfPointer;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", selfPointer=" + selfPointer + ", both=" + both + "]\r\n";
	}

}
