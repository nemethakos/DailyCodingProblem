package Oct8_Problem39;

public class Cell {

	private int x;
	private int y;

	public static boolean getNextState(boolean currentState, int neighboursCount) {
		boolean result = true;

		if (currentState) {
			// living cell
			if (neighboursCount < 2 || neighboursCount > 3) {
				result = false;
			}
		} else {
			// dead cell
			if (neighboursCount == 3) {
				result = true;
			} else {
				result = false;
			}
		}

		return result;
	}

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cell [x=").append(x).append(", y=").append(y).append("]");
		return builder.toString();
	}
}
