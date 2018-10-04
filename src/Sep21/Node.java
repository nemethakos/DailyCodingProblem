package Sep21;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Node {
	char c;
	boolean terminal;
	Map<Character, Node> children = new HashMap<>();

	public boolean isLeaf() {
		return children.size() == 0;
	}
	
	public Node addChild(char c, boolean terminal) {

		Node child = children.get(c);

		if (child != null) {
			child.terminal |= terminal;
			return child;
		} else {
			Node n = new Node(c, terminal);
			children.put(c, n);
			return n;
		}
	}
	
	public Node getChild(char c) {
		Node child = children.get(c);
		return child;
	}

	
	void printNode(StringBuilder sb, Node n, int level) {
		var spaces = String.join("", Collections.nCopies(level, "...."));
		sb.append(spaces + n.c + (n.terminal ? "*" : "") + "\r\n");
		var i = n.children.values().iterator();
		while (i.hasNext()) {
			printNode(sb, i.next(), level+1);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		printNode(sb, this, 0);
		return sb.toString();
	}

	public char getC() {
		return c;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public Node(char c, boolean terminal) {
		super();
		this.c = c;
		this.terminal = terminal;
	}
}
