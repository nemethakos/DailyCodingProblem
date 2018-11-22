package Problem84;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * <b>Note:</b> This solution uses {@link Set}s and {@link Map} of
 * {@link Point}s to check if a cell is belonging to an already existing island.
 * The other solution would be using
 * <a href="https://algs4.cs.princeton.edu/15uf/">Weighted quick-union with path
 * compression</a>
 * <p>
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. A
 * 1 represents land and 0 represents water, so an island is a group of 1s that
 * are neighboring and their perimiter is surrounded by water.
 * 
 * <p>
 * For example, this matrix has 4 islands.
 * 
 * <pre>
 * <span  style="background-color: DEEPSKYBLUE">
<span style="background-color: lime">1</span> 0 0 0 0
0 0 <span style="background-color: lime">1 1</span> 0
0 <span style="background-color: lime">1 1</span> 0 0
0 0 0 0 0
<span style="background-color: lime">1 1</span> 0 0 <span style=
"background-color: lime">1</span>
<span style="background-color: lime">1 1</span> 0 0 <span style=
"background-color: lime">1</span>
</span>
 * </pre>
 */
public class Problem84 {

	public static class Point {
		private int row;
		private int col;

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
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
			Point other = (Point) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("(%s, %s)", row, col);
		}

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	/**
	 * <p>
	 * Returns the {@link Set} of {@link Set} of {@link Point}s (Set of Islands).
	 * <p>
	 * Only the <b>N</b>-North and <b>W</b>-West position is checked if it is an adjoining land
	 * (no diagonal cells (X) are checked)
	 * <pre>
	 * X N X
	 * W 1 X
	 * </pre>
	 * <p>
	 * Time complexity: O(n), n = number of land cells.
	 * <p>
	 * Space complexity: O(n+i), n = number of land cells, i = number of islands
	 * 
	 * @param matrix the matrix containing the map of land (1) or water (0)
	 * @return the {@link Set} of {@link Set} of {@link Point}s (Set of Islands)
	 */
	public static Set<Set<Point>> getNumberOfIslands(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new HashSet<>();
		}
		Map<Point, Set<Point>> map = new HashMap<>();
		Set<Set<Point>> setOfIslands = new HashSet<>();

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				if (isLand(matrix, row, col)) {

					Point center = new Point(row, col);

					Point west = new Point(row, col - 1);
					var westSet = map.get(west);

					Point north = new Point(row - 1, col);
					var northSet = map.get(north);

					// create new set
					if (westSet == null && northSet == null) {
						Set<Point> centerSet = new HashSet<>();
						centerSet.add(center);
						map.put(center, centerSet);
						setOfIslands.add(centerSet);

					} else if (westSet != null && northSet != null) {
						// only join the two sets if they are different
						if (!westSet.equals(northSet)) {
							setOfIslands.remove(westSet);
							// join the two sets and add center
							westSet.stream().forEach(p -> map.put(p, northSet));
							northSet.addAll(westSet);
							westSet.clear();
						}
						northSet.add(center);
						map.put(center, northSet);

						// join to the north set
					} else if (westSet == null && northSet != null) {
						map.put(center, northSet);
						northSet.add(center);

						// join to the west set
					} else if (westSet != null && northSet == null) {
						map.put(center, westSet);
						westSet.add(center);
					}

				}
			}
		}

		return setOfIslands;
	}

	private static boolean isLand(int[][] matrix, int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
			return false;
		}
		return matrix[row][col] > 0;
	}
}
