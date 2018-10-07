package Oct7_Problem38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("serial")
public class Arrangement extends HashSet<Position> {
	private int boardWidth;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Arrangement [boardWidth=").append(boardWidth).append(", toString()=").append(super.toString())
				.append("]");
		return builder.toString();
	}

	public Arrangement(int boardWidth) {
		super();
		this.boardWidth = boardWidth;
	}

	public boolean isAllowed(int x, int y) {
		boolean allowed = true;
		for (var pos : this) {
			allowed &= pos.getAllowedPositions()[x][y];
		}
		return allowed;
	}

	public List<Position> getAllowedPositionList() {
		List<Position> result = new ArrayList<Position>();
		for (var x = 0; x < boardWidth; x++) {
			for (var y = 0; y < boardWidth; y++) {
				if (isAllowed(x, y)) {
					result.add(new Position(x, y, boardWidth));
				}
			}
		}

		return result;
	}

	public List<Position> getAllowedPositionListForRow(int row) {
		List<Position> result = new ArrayList<Position>();
		for (var x = 0; x < boardWidth; x++) {
			if (isAllowed(x, row)) {
				result.add(new Position(x, row, boardWidth));
			}
		}

		return result;
	}

	public void print() {
		System.out.println("Number of queens: " + this.size());
		for (var x = 0; x < boardWidth; x++) {
			for (var y = 0; y < boardWidth; y++) {
				char c = '.';
				if ((x + y) % 2 == 0) {
					c = ' ';
				}
				boolean allowed = true;
				boolean queen = false;
				for (var pos : this) {
					// System.out.println(pos);
					allowed &= pos.getAllowedPositions()[x][y];
					if (pos.getX() == x && pos.getY() == y) {
						queen = true;
					}
				}
				if (!allowed) {
					c = 'x';
				}
				if (queen) {
					c = 'Q';
				}
				System.out.print(c);
			}
			System.out.println();
		}

	}

}
