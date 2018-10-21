package Problem38;

public class Position {
	private int x;
	private int y;
	private int boardWidth;
	private boolean[][] allowedPositions;

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
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	private void initAllowed() {
		for (var a = 0; a < boardWidth; a++) {
			for (var b = 0; b < boardWidth; b++) {
				boolean sameColumn = a == x;
				boolean sameRow = b == y;
				boolean diagUp = (x - a == y - b);
				boolean diagDown = (x - a == -(y - b));
				allowedPositions[a][b] = !(sameColumn || sameRow || diagUp || diagDown);
			}
		}
	}

	public Position(int x, int y, int boardWidth) {
		super();
		this.x = x;
		this.y = y;
		this.boardWidth = boardWidth;
		allowedPositions = new boolean[boardWidth][boardWidth];
		initAllowed();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public boolean[][] getAllowedPositions() {
		return allowedPositions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Position [x=").append(x).append(", y=").append(y).append("]");
		return builder.toString();
	}
	
	

}
