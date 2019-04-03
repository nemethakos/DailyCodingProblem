package Problem77;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Given a list of possibly overlapping intervals, return a new list of
 * intervals where all overlapping intervals have been merged.
 * 
 * <p>
 * The input list is not necessarily ordered in any way.
 * 
 * <p>
 * For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return
 * [(1, 3), (4, 10), (20, 25)].
 */
public class Problem77 {

	public static class Interval {
		int start;
		int end;

		public static Interval get(int start, int end) {
			Interval interval = new Interval();
			interval.start = start;
			interval.end = end;
			return interval;
		}

		@Override
		public String toString() {
			return String.format("(%s, %s)", start, end);
		}

	}

	public static List<Interval> mergeOverlappingIntervals(List<Interval> intervals) {

		Collections.sort(intervals, (a, b) -> a.start - b.start);

		int index = 0;
		while (index < intervals.size() - 1) {

			if (overlap(intervals.get(index), intervals.get(index + 1))) {

				var interval1 = intervals.get(index);
				var interval2 = intervals.get(index + 1);

				intervals.remove(interval1);
				intervals.remove(interval2);

				System.out.print("intervals to merge: " + interval1 + ", " + interval2);

				Interval merged = merge(interval1, interval2);

				System.out.println(" -> " + merged);

				intervals.add(index, merged);
			} else {
				index++;
			}
		}

		return intervals;
	}

	private static Interval merge(Interval interval1, Interval interval2) {
		return Interval.get(interval1.start, Math.max(interval1.end, interval2.end));
	}

	private static boolean overlap(Interval interval1, Interval interval2) {
		return interval1.end >= interval2.start;
	}

}
