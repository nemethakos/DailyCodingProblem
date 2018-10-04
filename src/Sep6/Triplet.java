package Sep6;

import java.util.ArrayList;
import java.util.List;

public class Triplet {
	private List<String> stringList = new ArrayList<>();

	public Triplet(String... texts) {
		super();

		for (var text : texts) {
			if (text != null && text.length() > 0) {
				stringList.add(text);
			}
		}
	}

	public List<String> getStringList() {
		return stringList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stringList == null) ? 0 : stringList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triplet other = (Triplet) obj;
		if (stringList == null) {
			if (other.stringList != null)
				return false;
		} else if (!stringList.equals(other.stringList))
			return false;
		return true;
	}

}
