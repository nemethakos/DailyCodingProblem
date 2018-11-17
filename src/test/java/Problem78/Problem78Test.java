package Problem78;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class Problem78Test {

	static final int LENGTH_OF_LIST = 10;
	private static final int NUMBER_OF_LISTS = 100;

	@Test
	void testMerge() {

		var lists = Util.getLists(NUMBER_OF_LISTS, LENGTH_OF_LIST);
		// the lists will be destroyed after the merge, so we need the same list of
		// linked lists for checking
		var originalLists = Util.getLists(NUMBER_OF_LISTS, LENGTH_OF_LIST);

		var merged = Problem78.merge(lists, (a, b) -> a.intValue() - b.intValue());
		// check if all values in the list of linked lists are present in the merged
		// list
		assertTrue(Util.hasAllValues(originalLists, merged));

		// check if the merged list is in order
		assertTrue(Util.isOrdered(merged));
	}

}
