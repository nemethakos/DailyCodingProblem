package Problem78;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class Problem78HeapTest {
	static final int LENGTH_OF_LIST = 3;
	private static final int NUMBER_OF_LISTS = 3;

	@Test
	void testMerge() {

		var lists = Util.getLists(NUMBER_OF_LISTS, LENGTH_OF_LIST);
		// the lists will be destroyed after the merge, so we need the same list of
		// linked lists for checking
		var originalLists = Util.getLists(NUMBER_OF_LISTS, LENGTH_OF_LIST);
		System.out.println("original:"+originalLists);
		
		var merged = Problem78Heap.merge(lists, (a, b) -> a.value.intValue() - b.value.intValue());
		System.out.println("merged:"+merged);
		// check if all values in the list of linked lists are present in the merged
		// list
		assertTrue(Util.hasAllValues(originalLists, merged));

		// check if the merged list is in order
		assertTrue(Util.isOrdered(merged));
	}

}
