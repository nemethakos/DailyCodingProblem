package Problem76;

import org.junit.jupiter.api.Test;

class Problem76Test {

	@Test
	void testLex() {
		{
			int count = Problem76.lex(new char[][] { //
					{ 'c', 'b', 'a' }, //
					{ 'd', 'a', 'f' }, //
					{ 'g', 'h', 'i' },//
			});
			System.out.println("Columns to be removed: " + count);
		}

		{
			int count = Problem76.lex(new char[][] { //
				{ 'a', 'b', 'c', 'd', 'e', 'f' }//
		});
		System.out.println("Columns to be removed: " + count);
		}
	
		
		{
			int count = Problem76.lex(new char[][] { //
				{ 'z', 'y', 'x' }, //
				{ 'w', 'v', 'u' }, //
				{ 't', 's', 'r' },//
		});
		System.out.println("Columns to be removed: " + count);
			
			
		}
		
	}

}
