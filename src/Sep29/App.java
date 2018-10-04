package Sep29;

public class App {

	private static int getMaxValue(int[] arr) {
		int result = 0;
		for (var i = 0; i < arr.length; i++) {
			if (arr[i] > result) {
				result = arr[i];
			}
		}
		return result;
	}

	private static void printWater(int[] elevation, int water[]) {
		int height = getMaxValue(elevation);
		int width = elevation.length;
		char[][] disp = new char[width][height];
		init(disp, '.');
		for (var x = 0; x < width; x++) {
			drawLine(disp, x, 0, elevation[x] - 1, '#');
			drawLine(disp, x, elevation[x], elevation[x] + water[x] - 1, '~');
		}
		for (var y = height - 1; y >= 0; y--) {
			for (var x = 0; x < width; x++) {
				System.out.print(disp[x][y]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void init(char[][] disp, char c) {
		int width = disp.length;
		int height = disp[0].length;
		for (var x = 0; x < width; x++) {
			for (var y = 0; y < height; y++) {
				disp[x][y] = c;
			}
		}

	}

	private static void drawLine(char[][] disp, int x, int from, int to, char c) {
		char[] height = disp[x];
		for (var y = from; y <= to; y++) {
			height[y] = c;
		}

	}

	private static int findNextDownwardEdge(int[] elevation, int start, int startHeight) {
		int i = start;
		while (i < elevation.length && !(elevation[i] < elevation[i - 1])) {
			i++;
		}
		return i;
	}

	public static int getTrappedWaterAmount(int[] elev) {

		int[] waterLevel = new int[elev.length];
		int result = 0;
		int start, end;
		int startHeight = 0;

		start = findNextDownwardEdge(elev, 1, 0);
		startHeight = elev[start];

		while (start < elev.length) {
			end = findNextUpWardEdge(elev, start + 1, startHeight);
			end = findNextDownwardEdge(elev, end + 1, startHeight);
			int waterAmountTrapped = getTrappedWaterAmount(elev, start - 1, end - 1, waterLevel);

			result += waterAmountTrapped;
			start = end;
		}
		printWater(elev, waterLevel);
		return result;
	}

	private static int findNextUpWardEdge(int[] elevation, int start, int startHeight) {
		int i = start;
		while (i < elevation.length && !(elevation[i] > elevation[i - 1])) {
			i++;
		}
		return i;
	}

	private static int getTrappedWaterAmount(int[] elev, int from, int to, int[] waterLevel) {
		int waterTrapped = 0;
		if (from < elev.length && to < elev.length) {
			int maxLevel = Math.min(elev[from], elev[to]);
			for (var curr = from + 1; curr < to; curr++) {
				int waterLevelAtCurrent = maxLevel - elev[curr];
				if (waterLevelAtCurrent < 0) {
					waterLevelAtCurrent = 0;
				}
				waterLevel[curr] = waterLevelAtCurrent;
				waterTrapped += waterLevelAtCurrent;
			}
		}
		return waterTrapped;
	}

	public static void main(String[] args) {

		int terrainLength = 100;
		int[] terrain = new int[terrainLength];
		for (int i = 0; i < terrain.length; i++) {
			int height = (int) (//
			//
					((Math.sin((float) i / 10.0) + 1.0) * 10.0) + //
					((Math.sin((float) i / 3.0) + 1.0) * 4.0)//
			);
			terrain[i] = height;
		}

		System.out.println(getTrappedWaterAmount(terrain));
	}

}
