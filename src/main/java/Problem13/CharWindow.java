package Problem13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@SuppressWarnings("serial")
public class CharWindow extends LinkedList<Character> {

	private Set<Character> charsInList = new HashSet<>();

	private int maxDifferentCharacters = 0;

	public CharWindow(int maxDifferentCharacters) {
		super();
		this.maxDifferentCharacters = maxDifferentCharacters;
	}

	/**
	 * Adds char to the end of the list. If the number of different characters
	 * exceeds the maxDifferentCharacters, the character at the end of the list will
	 * be removed.
	 * 
	 * @param c
	 * @return the number of different characters in the list
	 */
	public int addChar(char c) {
		this.addFirst(c);
		charsInList.add(c);
		if (charsInList.size() > maxDifferentCharacters) {
			// remove last char
			char last = this.getLast();
			charsInList.remove(last);
			this.removeLast();
		}
		return this.size();
	}
	
	public String getAsString() {
		StringBuilder sb = new StringBuilder();
		
		var i = this.iterator();
		while (i.hasNext()) {
			sb.append(i.next());
		}
		
		return sb.toString();
	}

}
