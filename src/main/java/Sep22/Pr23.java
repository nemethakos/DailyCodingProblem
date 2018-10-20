package Sep22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static Sep22.Move.*;

public class Pr23 {

	@SuppressWarnings("unused")
	private static String[] map1 = { //
			" |   |   |", //
			" | | | | |", //
			" | | | | |", //
			" | | | | |", //
			" | | | | |", //
			" | | | | |", //
			" | | | | |", //
			" | | | | |", //
			" | |   |  ", //
			" | -----| ", //
			"        | ", //
	};
	private static String[] map2 = { //
			"g                 ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                  ", //
			"                 s", //
	};

	private List<Path> getPossiblePaths(Map map, final Coord goal, Path path) {
		List<Path> possiblePaths = new ArrayList<Path>();

		Coord pos = path.getLast();

		possiblePaths.add(path.newPathWith(pos.move(UP)));
		possiblePaths.add(path.newPathWith(pos.move(DOWN)));
		possiblePaths.add(path.newPathWith(pos.move(LEFT)));
		possiblePaths.add(path.newPathWith(pos.move(RIGHT)));

		var validPaths = new ArrayList<Path>();
		for (var possiblePath : possiblePaths) {
			Coord newPosition = possiblePath.getLast();
			if (map.isFreeTile(newPosition) && !possiblePath.isLastPositionAppearsBefore()) {
				validPaths.add(possiblePath);
			}
		}

		Collections.sort(validPaths, new Comparator<Path>() {

			@SuppressWarnings("unused")
			@Override
			public int compare(Path o1, Path o2) {
				var d1 = o1.getLast().distanceFrom(goal);
				var d2 = o2.getLast().distanceFrom(goal);
				
				float diff = d1-d2;
				
				int result = (int) Math.signum(diff);
				
				return (int)diff;
			}
		});

		return validPaths;
	}

	Path getPath(Map map, Coord goal, Path currentPath, int minSteps) {

		//System.out.println(map.toStringWithOverlay(currentPath, '*'));

		// System.out.println("" + currentPath.getLast() + ", goal: " + goal);

		if (currentPath.getLast().equals(goal)) {
			minSteps = currentPath.size();
			//System.out.println("Found: " + currentPath + ", minSteps: " + minSteps);
			return currentPath;
		}
		if (minSteps < currentPath.steps()) {
			//System.out.println("Abort " + currentPath + ", minSteps: " + minSteps);
			return null;
		}

		var possiblePaths = getPossiblePaths(map, goal, currentPath);
		// System.out.println(possiblePaths);

		Path best = null;

		for (var move : possiblePaths) {
			var foundPath = getPath(map, goal, move, minSteps);
			if (foundPath != null) {
				best = foundPath;
				minSteps = foundPath.size();
				return foundPath;
			}
		}

		return best;
	}

	public Path getBestPath(Map map, Coord start, Coord goal) {
		var path = getPath(map, goal, Path.from(start), Integer.MAX_VALUE);

		return path;
	}

	public void printPath(String[] mapString) {
		Map map = new Map(mapString);
		var start = map.findChar('s');
		var goal = map.findChar('g');
		map.setChar(goal, ' ');
		var path = getBestPath(map, start, goal);

		System.out.println(map.toStringWithOverlay(path, '*'));
	}

	public static void main(String... args) {
		Pr23 app = new Pr23();

		app.printPath(map2);
	}
}
