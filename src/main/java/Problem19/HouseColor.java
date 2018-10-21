package Problem19;

public class HouseColor {
	
	private int color;
	private int cost;
	private int house;
	public HouseColor(int house, int color, int cost) {
		super();
		this.house = house;
		this.color = color;
		this.cost = cost;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HouseColor other = (HouseColor) obj;
		if (color != other.color)
			return false;
		if (cost != other.cost)
			return false;
		if (house != other.house)
			return false;
		return true;
	}
	public int getColor() {
		return color;
	}
	public int getCost() {
		return cost;
	}
	public int getHouse() {
		return house;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color;
		result = prime * result + cost;
		result = prime * result + house;
		return result;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setHouse(int house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "HouseColor [house=" + house + ", color=" + color + ", cost=" + cost + "]";
	}

}
