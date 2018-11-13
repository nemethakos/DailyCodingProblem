package Problem54;

public class Sudoku {

	int[][] boxes = new int[9][9];

	public Sudoku(int[][] boxes) {
		super();
		this.boxes = boxes;
	}
	
	protected boolean checkRow(int row) {
		return false;
	}
	
	protected boolean checkColumn(int column) {
		return false;
	}
	
	protected boolean checkBox(int boxColumn, int boxRow) {
		return false;
	}
	
	public boolean isSolved() {
		return false;
	}
	
}
