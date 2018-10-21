package Problem21;

public class Interval {
	private String name;
	private int start;
	private int end;
	
	
	
	@Override
	public String toString() {
		return ""+name+"(" + start + ", " + end + ")";
	}



	public Interval(String name, int start, int end) {
		super();
		
		if (end <= start) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.start = start;
		this.end = end;
	}



	public int intersect(Interval other) {
		int result = 0;
		if(!((this.end <= other.start) || (other.end <= this.start))) {
			result = 1;
			System.out.println("Intersect: " + this + " - " + other);
		} 
		return result;
	}
}
