package Problem77;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static Problem77.Problem77.mergeOverlappingIntervals;
import static Problem77.Problem77.Interval.get;

import Problem77.Problem77.Interval;

class Problem77Test {

	@Test
	void testMergeOverlappingIntervals() {
		{
			List<Interval> overlaps = new ArrayList<>();
			overlaps.add(get(1, 3));
			overlaps.add(get(5, 8));
			overlaps.add(get(4, 10));
			overlaps.add(get(20, 25));

			System.out.println("\r\n\r\nOverlapping intervals: " + overlaps);

			System.out.println("Merged result: " + mergeOverlappingIntervals(overlaps));
		}

		{
			List<Interval> overlaps = new ArrayList<>();
			// touching intervals
			overlaps.add(get(1, 10));
			overlaps.add(get(10, 20));
			overlaps.add(get(20, 30));
			overlaps.add(get(30, 40));
			
			// one interval in an other one
			overlaps.add(get(50, 70));
			overlaps.add(get(55, 65));
			
			// partially overlap
			overlaps.add(get(80, 90));
			overlaps.add(get(85, 100));
			
			// fully overlap, ends touching
			overlaps.add(get(200, 300));
			overlaps.add(get(250, 300));
			
			// fully overlap, starts touching
			overlaps.add(get(400, 500));
			overlaps.add(get(400, 450));
			
			

			System.out.println("\r\n\r\nOverlapping intervals: " + overlaps);

			System.out.println("Merged result: " + mergeOverlappingIntervals(overlaps));
		}

	
	}

}
