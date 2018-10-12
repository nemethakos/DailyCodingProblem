package Sep16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryTree {
	List<Integer> pathLengths = new ArrayList<>();
	int maxLength = 0;

	private DirectoryTree(String text) {
		makeTree(text);
	}

	int getPrevSize(int level) {
		int result = 0;

		if (level > 0 && pathLengths.size() >= level) {
			result = pathLengths.get(level - 1);
		}
		return result;
	}

	private void setSize(int level, int size) {
		if (pathLengths.size()<=level) {
			pathLengths.add(size);
		}
		else {
			pathLengths.set(level, size);
		}
	}

	int getCurrentSize(int level, int size) {
		int current = getPrevSize(level) + size;
		setSize(level, current);
		return current;
	}

	private void makeTree(String text) {

		List<String> elements = Arrays.asList(text.split("\n"));

		for (var element : elements) {
			int level = numTabs(element);
			boolean isFileName = element.contains(".");
			int elementLength = element.substring(level).length();
			if (!isFileName) {
				elementLength += 1;
			}
			int total = getCurrentSize(level, elementLength);
			if (isFileName) {
				if (maxLength < total) {
					maxLength = total;
				}
			}
		}
	}

	private int numTabs(String element) {

		int i = 0;
		while (element.length() > i && element.charAt(i) == '\t') {
			i++;
		}
		return i;
	}

	@Override
	public String toString() {
		return "DirectoryTree [levelMaxLength=" + pathLengths + ", maxLength=" + maxLength + "]";
	}

	public static DirectoryTree of(String text) {
		return new DirectoryTree(text);
	}

}
