package Problem53;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class TwoStacksQueueTest {

	@Test
	void testAdd() {
		TwoStacksQueue<Integer> q = new TwoStacksQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		assertTrue(q.dequeue() == 1);
		assertTrue(q.dequeue() == 2);
		assertTrue(q.dequeue() == 3);
	}

	@Test
	void testPeek() {
		TwoStacksQueue<Integer> q = new TwoStacksQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		assertTrue(q.peek() == 1);
	}

	@Test
	void testIsEmpty() {
		TwoStacksQueue<Integer> q = new TwoStacksQueue<>();
		assertTrue(q.isEmpty());
		
		q.enqueue(1);

		assertFalse(q.isEmpty());
		
		q.dequeue();
		
		assertTrue(q.isEmpty());

	}

}
