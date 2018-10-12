package Sep18;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class HouseList extends ArrayList<HouseColor> {

	public HouseList(HouseList list) {
		super(list);
	}

	public HouseList() {
	}

	public int getCost() {
		int result = 0;
		var i = this.iterator();
		while (i.hasNext()) {
			result+=i.next().getCost();
		}

		return result ;
	}

	public void addHouseColor(HouseColor houseColor) {
		super.add(houseColor);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<this.size(); i++) {
			sb.append(get(i).getColor());
		}
		sb.append(":"+this.getCost());
		return sb.toString();
	}
	
}
