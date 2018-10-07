package Oct7_Problem38;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * <b>The problem:</b>You have an N by N board. Write a function that, given N,
 * returns the number of possible arrangements of the board where N queens can
 * be placed on the board without threatening each other, i.e. no two queens
 * share the same row, column, or diagonal.
 * 
 * <p>
 * <b>The eight queen problem on wikipedia:</b><a href=
 * "https://en.wikipedia.org/wiki/Eight_queens_puzzle">https://en.wikipedia.org/wiki/Eight_queens_puzzle</a>
 */
public class Pr38 {

	/**
	 * Optimized version, places the new queen in a new row
	 * 
	 * @param allArrangements collects the possible arrangements
	 * @param current         the current arrangement
	 * @param boardWidth      width/height of board
	 * @param counter         counts the number of arrangements checked
	 */
	void getAllArrangementsWithBacktrackingRowOptimalization(List<Arrangement> allArrangements, Arrangement current,
			int boardWidth, AtomicInteger counter) {

		if (current.size() < boardWidth && !current.getAllowedPositionList().isEmpty()) {
			var allowedPositions = current.getAllowedPositionListForRow(current.size());
			for (var pos : allowedPositions) {
				var newArrangement = new Arrangement(boardWidth);
				newArrangement.addAll(current);
				newArrangement.add(pos);
				counter.incrementAndGet();
				getAllArrangementsWithBacktrackingRowOptimalization(allArrangements, newArrangement, boardWidth,
						counter);
			}
		} else if (current.size() == boardWidth) {
			allArrangements.add(current);
		}
	}

	/**
	 * Backtracking brute force algorithm
	 * 
	 * @param allArrangements collects the possible arrangements
	 * @param current         the current arrangement
	 * @param boardWidth      width/height of board
	 * @param counter         counts the number of arrangements checked
	 */
	void getAllArrangementsWithBacktrackingWithNoOptimalization(List<Arrangement> allArrangements, Arrangement current,
			int boardWidth, AtomicInteger counter) {

		if (counter.get() % 1000000 == 0) {
			System.out.println("Arrangements checked: " + counter.get());
		}

		var allowedPositions = current.getAllowedPositionList();
		if (allowedPositions.isEmpty()) {
			// no more queens can be placed
			if (current.size() == boardWidth) {
				if (!allArrangements.contains(current)) {
					allArrangements.add(current);
					current.print();
				}
			}

		} else {
			// try adding a new queen
			for (var pos : allowedPositions) {
				var newArrangement = new Arrangement(boardWidth);
				newArrangement.addAll(current);
				newArrangement.add(pos);
				counter.incrementAndGet();
				getAllArrangementsWithBacktrackingWithNoOptimalization(allArrangements, newArrangement, boardWidth,
						counter);

			}
		}
	}

	public void testNQueens(int boardWidth) {
		AtomicInteger counter = new AtomicInteger(0);
		List<Arrangement> allArrangements = new ArrayList<>();
		var current = new Arrangement(boardWidth);
		getAllArrangementsWithBacktrackingRowOptimalization(allArrangements, current, boardWidth, counter);
		System.out.println(
				"Board width:" + boardWidth + ", #arrangements: " + allArrangements.size() + "(" + counter + ")");
	}

	public static void main(String[] args) {
		var app = new Pr38();

		for (int i = 1; i <= 10; i++) {
			app.testNQueens(i);
		}

	}

}
