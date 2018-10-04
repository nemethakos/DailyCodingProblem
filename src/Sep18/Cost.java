package Sep18;

public class Cost {
	
	private int cost[][];
	
	public Cost(int[][] cost) {
		super();
		this.cost = cost;
	}

	public int getNumberOfHouses() {
		return cost.length;
	}
	
	public int getNumberOfColors() {
		return cost[0].length;
	}
	
	public HouseColor getHouseColor(int house, int color) {
		return new HouseColor(house, color, cost[house][color]);
	}

	public int getCost(int house, int color) {
		return cost[house][color];
	}
}
