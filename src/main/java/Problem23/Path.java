package Problem23;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Path extends ArrayList<Coord> {

	public Path(Path path) {
		super(path);
	}

	public Path() {
		super();
	}

	public static Path from(Coord coord) {
		Path path = new Path();
		path.add(coord);
		return path;
	} 
	
	public Path newPathWith(Coord move) {
		Path result = new Path(this);
		result.add(move);
		return result;
	}
	
	public Coord getLast() {
		return this.get(this.size() - 1);
	}
	
	public boolean isLastPositionAppearsBefore() {
		var last = remove(this.size()-1);
		boolean result = this.contains(last);
		this.add(last);
		return result;
	}
	
	public int steps() {
		return size();
	}

}
