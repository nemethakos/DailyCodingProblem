package Sep14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Pr15 {

	public static void main(String... args) {

		var list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		System.out.println(getRandomElement(list.stream().iterator()));
	}

	private static int getRandomElement(Iterator<Integer> iterator) {
		int count = 0;
		int pickedNumber = 0;

		while (iterator.hasNext()) {
			var nextValue = iterator.next();
			if (count == 0) {
				pickedNumber = nextValue;
			} else {
				var chance = ThreadLocalRandom.current().nextInt(1, count + 1) == 1;
				if (chance) {
					pickedNumber = nextValue;
				}
			}
			count++;
		}

		return pickedNumber;
	}

}
