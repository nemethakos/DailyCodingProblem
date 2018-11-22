package Problem84;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem84Test {

	@Test
	void testGetNumberOfIslands() {
		int[][] matrix = new int[][] {
			{1, 0, 0, 0, 0},//
			{0, 0, 1, 1, 0},//
			{0, 1, 1, 0, 0},//
			{0, 0, 0, 0, 0},//
			{1, 1, 0, 0, 1},//
			{1, 1, 0, 0, 1}};//
			
			var islands = Problem84.getNumberOfIslands(matrix);
			System.out.println("Islands: " + islands);
			 
			assertEquals(4, islands.size());
	}

}
