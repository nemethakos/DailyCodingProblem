package Sep22;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private char[][] map;
	private int width;
	private int height;

	public Coord findChar(char c) {
		
		for (var row=0; row<height; row++) {
			for (var col=0; col<width; col++) {
				if (map[col][row]==c) {
					return new Coord(col,row);
				}
			}
		}
		
		return null;
	}
	
	public void setChar(Coord pos, char c) {
		this.map[pos.x][pos.y] = c;
	}
	
	public Map(String[] map) {
		width = map[0].length();
		height = map.length;
		this.map = new char[width][height];
		for (var col = 0; col < width; col++) {
			for (var row = 0; row < height; row++) {
				this.map[col][row] = map[row].charAt(col);
			}
		}
	}

	public Map(char[][] map) {
		super();
		this.map = map;
		this.width = map[0].length;
		this.height = map.length;
	}

	public boolean isFreeTile(Coord pos) {
		boolean result = false;

		if (pos.x < 0 || pos.x > this.width - 1 || pos.y < 0 || pos.y > this.height - 1) {
			result = false;
		} else {
			result = map[pos.x][pos.y] == ' ';
		}

		return result;
	}

	public String toStringWithOverlay(List<Coord> overlay, char overlayChar) {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {
				char chr = map[col][row];
				if (chr == ' ') {
					chr = '.';
				}
				if (overlay.contains(Coord.from(col, row))) {
					chr = overlayChar;
				}
				sb.append(chr);
			}
			sb.append("\r\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return toStringWithOverlay(new ArrayList<Coord>(), ' ');
	}

}
