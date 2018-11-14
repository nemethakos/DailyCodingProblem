package Problem76;

/**
 * <p>
 * You are given an N by M 2D matrix of lowercase letters. Determine the minimum
 * number of columns that can be removed to ensure that each row is ordered from
 * top to bottom lexicographically. That is, the letter at each column is
 * lexicographically later as you go down each row. It does not matter whether
 * each row itself is ordered lexicographically.
 * 
 * <p>
 * For example, given the following table:
 * 
 * <pre>
cba
daf
ghi
 * </pre>
 * 
 * <p>
 * This is not ordered because of the a in the center. We can remove the second
 * column to make it ordered:
 * 
 * <pre>
ca
df
gi
 * </pre>
 * 
 * <p>
 * So your function should return 1, since we only needed to remove 1 column.
 * 
 * <p>
 * As another example, given the following table:
 * 
 * <pre>
 * abcdef
 * </pre>
 * 
 * <p>
 * Your function should return 0, since the rows are already ordered (there's
 * only one row).
 * 
 * <p>
 * As another example, given the following table:
 * 
 * <pre>
zyx
wvu
tsr
 * </pre>
 * 
 * <p>
 * Your function should return 3, since we would need to remove all the columns
 * to order it.
 */
public class Problem76 {

	public static int lex(char[][] matrix) {
		int rowNum = matrix.length;
		int colNum = matrix[0].length;

		System.out.println("rownum: " + rowNum + " colnum: "+ colNum);
		
		if (rowNum <= 1) {
			return 0;
		}

		int columnsToRemove = 0;

		for (var col = 0; col < colNum; col++) {
			if (!isLexiographicallyOrdered(matrix, col)) {
				System.out.println("Column " + col + " is to be removed");
				columnsToRemove++;
			}
		}

		return columnsToRemove;
	}

	private static boolean isLexiographicallyOrdered(char[][] matrix, int col) {
		int rowNum = matrix.length;
		for (var row = 1; row < rowNum; row++) {
			char nextChar = matrix[row][col];
			char prevChar = matrix[row - 1][col];
			
			if (nextChar < prevChar) {
				return false;
			}
		}

		return true;
	}

}
