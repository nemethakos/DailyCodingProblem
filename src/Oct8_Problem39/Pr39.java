package Oct8_Problem39;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Conway's Game of Life takes place on an infinite two-dimensional board of
 * square cells. Each cell is either dead or alive, and at each tick, the
 * following rules apply:
 * <ul>
 * <li>Any live cell with less than two live neighbours dies.
 * <li>Any live cell with two or three live neighbours remains living.
 * <li>Any live cell with more than three live neighbours dies.
 * <li>Any dead cell with exactly three live neighbours becomes a live cell.
 * </ul>
 * <p>
 * A cell neighbours another cell if it is horizontally, vertically, or
 * diagonally adjacent.
 * 
 * <p>
 * Implement Conway's Game of Life. It should be able to be initialized with a
 * starting list of live cell coordinates and the number of steps it should run
 * for.
 * <p>
 * Once initialized, it should print out the board state at each step. Since
 * it's an infinite board, print out only the relevant coordinates, i.e. from
 * the top-leftmost live cell to bottom-rightmost live cell.
 * <p>
 * You can represent a live cell with an asterisk (*) and a dead cell with a dot
 * (.).
 *
 */
public class Pr39 {

	public static void printGenerations(Plane plane, int generations) {
		System.out.println("Inital Generation:\r\n" + plane);
		for (int i = 0; i < generations; i++) {
			plane = plane.getNextGeneration();
			System.out.println("Generation: " + (i + 1));
			System.out.println(plane);
		}

	}

	public static void main(String[] args) {

		List<Cell> initialCells = new ArrayList<>();
		initialCells.add(new Cell(0, 0));
		initialCells.add(new Cell(0, 1));
		initialCells.add(new Cell(0, 2));
		initialCells.add(new Cell(1, 1));
		initialCells.add(new Cell(1, 2));
		initialCells.add(new Cell(1, 3));

		Plane p = new Plane();
		initialCells.stream().forEach(cell -> p.setCell(cell));

		printGenerations(p, 10);
	}

}
