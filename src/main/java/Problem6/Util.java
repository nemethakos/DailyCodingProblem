package Problem6;

import java.util.List;

public class Util {

	public static int get_pointer(List<Node> nodeHolder, Node node) {
		return nodeHolder.indexOf(node);
	}
	
	public static Node dereference_pointer(List<Node> nodeHolder, int pointer) {
		return nodeHolder.get(pointer);
	}
	
}
