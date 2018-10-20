package Sep20;

import java.util.ArrayList;
import java.util.List;

public class Pr21 {

	public static int numberOfClassRoomNeeded(List<Interval> intervals) {

		int numIntervals = intervals.size();
		int rowMax = 0;
		int colMax = 0;

		int[] rowSum = new int[numIntervals];
		int[] colSum = new int[numIntervals];

		for (int col = 0; col < numIntervals; col++) {
			for (int row = 0; row < numIntervals; row++) {
				if (col > row) {
					int numIntersection = intervals.get(col).intersect(intervals.get(row));

					rowSum[col] += numIntersection;
					colSum[row] += numIntersection;
				}
			}
		}

		for (int i = 0; i < numIntervals; i++) {
			if (rowSum[i] > rowMax) {
				rowMax = rowSum[i];
			}
			if (colSum[i] > colMax) {
				colMax = colSum[i];
			}
		}

		if (rowMax > colMax) {
			return rowMax;
		} else {
			return colMax;
		}

	}

	@SuppressWarnings("unused")
	private static void printArray(int[][] overlaps) {
		for (int i = 0; i < overlaps.length; i++) {
			for (int j = 0; j < overlaps[0].length; j++) {
				System.out.print(overlaps[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval("1", 30, 75));
		intervals.add(new Interval("2", 0, 50));
		intervals.add(new Interval("3", 60, 150));

		System.out.println("max overlaps: " + numberOfClassRoomNeeded(intervals));

		List<Interval> i = new ArrayList<Interval>();
		i.add(new Interval("1", 0, 2));
		i.add(new Interval("2", 1, 3));
		i.add(new Interval("3", 0, 6));
		i.add(new Interval("4", 0, 2));
		i.add(new Interval("5", 1, 5));
		i.add(new Interval("6", 0, 1));
		i.add(new Interval("7", 2, 3));
		i.add(new Interval("8", 8, 9));

		System.out.println("max overlaps: " + numberOfClassRoomNeeded(i));

	}

}
