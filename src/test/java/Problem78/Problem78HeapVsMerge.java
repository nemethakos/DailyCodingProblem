package Problem78;

import org.junit.jupiter.api.Test;

public class Problem78HeapVsMerge {
	static final int LENGTH_OF_LIST = 1000;
	private static final int NUMBER_OF_LISTS = 1000;

	@SuppressWarnings("unused")
    @Test
	void testMerge() {

		var lists = Util.getLists(NUMBER_OF_LISTS, LENGTH_OF_LIST);
		// the lists will be destroyed after the merge, so we need the same list of
		// linked lists for checking
		var originalLists = Util.getLists(NUMBER_OF_LISTS, LENGTH_OF_LIST);

		long start = System.nanoTime();
		
		var mergedMerge = Problem78.merge(lists, (a, b) -> a.intValue() - b.intValue());
		
		long mergeTime = System.nanoTime()-start;
		start = System.nanoTime();
		
		var mergedHeap = Problem78Heap.merge(lists, (a, b) -> a.value.intValue() - b.value.intValue());
		long heapTime = System.nanoTime()-start;
		
		System.out.format("Merge: %,.0f ns, Heap: %,.0f ns", (float)mergeTime, (float)heapTime);
		
	}

}
