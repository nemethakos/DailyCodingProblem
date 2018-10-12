package Sep22;

public class Coord {

	public int x;
	public int y;

	public float distanceFrom(Coord other) {
		float xdistance = other.x - this.x;
		float ydistance = other.y - this.y;
		return (float) Math.sqrt(xdistance * xdistance + ydistance * ydistance);
	}

	public Coord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Coord move(Move move) {
		switch (move) {
		case LEFT:
			return Coord.from(this.x - 1, this.y);
		case RIGHT:
			return Coord.from(this.x + 1, this.y);
		case UP:
			return Coord.from(this.x, this.y - 1);
		case DOWN:
			return Coord.from(this.x, this.y + 1);
		}
		return null;
	}

	public static Coord from(int x, int y) {
		return new Coord(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	
}
