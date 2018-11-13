package Problem54;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

	@Test
	void testSolve() {
		
		int[][] sudoku = {
				{5,3,0,  0,7,0,  0,0,0},
				{6,0,0,  1,9,5,  0,0,0},
				{0,9,8,  0,0,0,  0,6,0},
				
				{8,0,0,  0,6,0,  0,0,3},
				{4,0,0,  8,0,3,  0,0,1},
				{7,0,0,  0,2,0,  0,0,6},
				
				{0,6,0,  0,0,0,  2,8,0},
				{0,0,0,  4,1,9,  0,0,5},
				{0,0,0,  0,8,0,  0,7,9}
		};
		
		var filledSudoku = SudokuSolver.solve(new Sudoku(sudoku));
		
		assertTrue(filledSudoku.isSolved());
	}

}
