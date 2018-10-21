package Problem39;

import java.util.HashSet;

@SuppressWarnings("serial")
public class Plane extends HashSet<Cell> {

	private int minX;
	private int maxX;
	private int minY;
	private int maxY;

	private int getWidth() {
		if (this.size() > 0) {
			return maxX - minX + 1;
		} else {
			return 0;
		}
	}

	private int getHeight() {
		if (this.size() > 0) {
			return maxY - minY + 1;
		} else {
			return 0;
		}
	}

	public String toString() {
		int w = getWidth();
		int h = getHeight();

		char[][] field = new char[h][w];

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				field[y][x] = '.';
			}
		}

		this.stream().forEach(cell -> {
			int y = cell.getY() - minY;
			int x = cell.getX() - minX;
			field[y][x] = '*';
		});

		StringBuilder sb = new StringBuilder((w + 2) * h);
		for (int row = 0; row < h; row++) {
			sb.append(field[row]);
			sb.append("\r\n");
		}

		return sb.toString();
	}

	public Plane() {
		super();
		minX = Integer.MAX_VALUE;
		minY = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		maxY = Integer.MIN_VALUE;
	}

	public boolean getCell(Cell c) {
		return this.contains(c);
	}

	public void setCell(Cell c) {
		if (c.getX() >= maxX) {
			maxX = c.getX();
		}
		if (c.getX() <= minX) {
			minX = c.getX();
		}
		if (c.getY() >= maxY) {
			maxY = c.getY();
		}
		if (c.getY() <= minY) {
			minY = c.getY();
		}
		this.add(c);
	}

	public int getNeighboursCount(Cell c) {
		int x = c.getX();
		int y = c.getY();

		int result = 0;
		for (int ax = x - 1; ax <= x + 1; ax++) {
			for (int ay = y - 1; ay <= y + 1; ay++) {

				if (!(ax == x && ay == y) && this.getCell(new Cell(ax, ay))) {
					result++;
				}
			}
		}
		return result;
	}

	public Plane getNextGeneration() {
		Plane newGeneration = new Plane();

		var surroundingEmptyCellSet = new HashSet<Cell>();

		this.stream().forEach(cell -> {
			// living cells
			if (Cell.getNextState(true, this.getNeighboursCount(cell))) {
				newGeneration.setCell(cell);
			}
			// neighboring empty cells
			for (int x = cell.getX() - 1; x <= cell.getY() + 1; x++) {
				for (int y = cell.getY() - 1; y <= cell.getY() + 1; y++) {
					Cell emptyCell = new Cell(x, y);
					if (!this.getCell(emptyCell)) {
						surroundingEmptyCellSet.add(emptyCell);
					}
				}
			}
		});

		surroundingEmptyCellSet.stream().forEach(cell -> {
			if (Cell.getNextState(false, this.getNeighboursCount(cell))) {
				newGeneration.setCell(cell);
			}
		});

		return newGeneration;
	}

}
