package Problem81;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class Problem81Test {

	@Test
	void testGetAllPossibleRepresentations() {
		Map<String, List<String>> map = new TreeMap<>();
		map.put("2", Arrays.asList("a", "b", "c"));
		map.put("3", Arrays.asList("d", "e", "f"));
		map.put("4", Arrays.asList("g", "h", "i"));
		map.put("5", Arrays.asList("j", "k", "l"));
		map.put("6", Arrays.asList("m", "n", "o"));
		map.put("7", Arrays.asList("p", "q", "r", "s"));
		map.put("8", Arrays.asList("t", "u", "v"));
		map.put("9", Arrays.asList("w", "x", "y", "z"));
		
		List<String> representations = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
		
		assertEquals(representations, Problem81.getAllPossibleRepresentationsRecursive(map, "23"));
		
		var iterativeResult = Problem81.getAllPossibleRepresentationsIterative(map, "23");
		iterativeResult.sort(String::compareTo);
		assertEquals(representations, iterativeResult);
		
		//System.out.println(Problem81.getAllPossibleRepresentationsIterative(map, "23456789"));
				
	}

}
