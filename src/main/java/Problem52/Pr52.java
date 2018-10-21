package Problem52;

public class Pr52 {

	public static void main(String[] args) {

		LastRecentlyUsedCache<Integer, Integer> lru = new LastRecentlyUsedCache<>(10);

		// add elements 1-10
		for (int i = 1; i <= 10; i++) {
			lru.set(i, i);
		}
		
		// add priority to 1
		System.out.println(lru.get(1));
		
		// insert element 99, this removes element 2 (least important)
		lru.set(99,99);

		// elements 1,3,4,5,6,7,8,9,10,99
		System.out.println(lru);

	}

}
