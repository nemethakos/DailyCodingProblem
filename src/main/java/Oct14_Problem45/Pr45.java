package Oct14_Problem45;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Pr45 {

	@FunctionalInterface
	interface NumberGenerator {
		int generateNumber();
	}

	public static int rand5() {
		return (int) (Math.random() * 6);
	}

	public static int rand7() {
		int result = 0;
		for (var i = 0; i < 7; i++) {
			result += rand5();
		}
		return result % 7;
	}

	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<>();
		histogram(map, 1_000_000, () -> rand5());

		map.clear();
		histogram(map, 10_000_000, () -> rand7());
	}

	private static void histogram(Map<Integer, Integer> map, int numTries, NumberGenerator numberGenerator) {
		for (int i = 0; i < numTries; i++) {
			int num = numberGenerator.generateNumber();
			if (map.get(num) == null) {
				map.put(num, 0);
			}
			map.put(num, map.get(num) + 1);
			if (i % 1_000_000 == 0) {
				System.out.println(i);
			}
		}

		var sum = map.keySet().stream().collect(Collectors.summarizingInt(key -> map.get(key))).getSum();
		System.out.println(
				map.keySet().stream().map(key -> (((double) map.get(key)) * 100) / sum).collect(Collectors.toList()));

	}

}
