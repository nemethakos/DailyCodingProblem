package Sep18;

import java.util.ArrayList;
import java.util.List;

public class Pr19 {

	public Pr19(boolean skipEnabled) {
		super();
		this.skipEnabled = skipEnabled;
	}

	private boolean skipEnabled = false;

	private int counter = 0;

	private HouseList optimal = null;

	// house, color
	@SuppressWarnings("unused")
	private static int cost[][] = //
			{ //
					{ 1, 2, 3, 4, 5 }, //
					{ 5, 4, 3, 2, 1 }, //
					{ 1, 1, 1, 1, 1 }, //
					{ 9, 1, 9, 1, 9 }, //
					{ 1, 9, 1, 9, 1 }, //
					{ 1, 2, 3, 4, 5 }, //
					{ 5, 4, 3, 2, 1 }, //
					{ 1, 1, 1, 1, 1 }, //
					{ 9, 1, 9, 1, 9 }, //
					{ 1, 9, 1, 9, 1 },//
			};

	// house, color
	private static int unitcost[][] = //
			{ //
					{ 1, 1, 1, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 }, //
					{ 2, 1, 3, 1, 1 },//
			};

	private void lowestCost(HouseList selected, Cost cost) {

		// skip if selected has higher cost than optimal
		if (skipEnabled && optimal != null && selected.getCost() > optimal.getCost()) {
			// System.out.println("skip: " + selected);
			return;
		}

		// base condition. if all house-colors are selected, return it
		if (selected.size() == cost.getNumberOfHouses()) {
			if (optimal == null) {
				setOptimal(selected);
			} else if (optimal.getCost() > selected.getCost()) {
				setOptimal(selected);
			}
			return;
		}

		int optimalCost = Integer.MAX_VALUE;
		if (optimal != null) {
			optimalCost = optimal.getCost();
		}
		counter++;

		// add the next level to the choices except the invalid ones
		List<HouseList> validChoices = addAllValidChoices(selected, cost, optimalCost);

		for (var choice : validChoices) {
			lowestCost(choice, cost);
		}

	}

	private void setOptimal(HouseList selected) {
		System.out.println("Optimal: " + selected);
		optimal = selected;
	}

	private List<HouseList> addAllValidChoices(HouseList selected, Cost cost, int optimalCost) {
		List<HouseList> result = new ArrayList<>();
		int nextHouse = 0;
		int lastColor = -1;

		if (selected.size() > 0) {

			HouseColor lastHouse = selected.get(selected.size() - 1);
			nextHouse = lastHouse.getHouse() + 1;
			lastColor = lastHouse.getColor();
		}

		for (int color = 0; color < cost.getNumberOfColors(); color++) {
			if (lastColor != color) {
				HouseList alternative = new HouseList(selected);
				alternative.add(new HouseColor(nextHouse, color, cost.getCost(nextHouse, color)));
				result.add(alternative);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Cost paintCost = new Cost(unitcost);
		var app = new Pr19(true);
		app.lowestCost(new HouseList(), paintCost);
		double allCombinations = Math.pow(paintCost.getNumberOfColors() - 1, paintCost.getNumberOfHouses());
		double checkRatio = (double) app.counter / allCombinations;
		System.out.format("All combinations: %.0f, check ratio: %f%n", allCombinations, checkRatio);

		System.out.format("Lowest cost: %s, iterations: %d%n", app.optimal, app.counter);
	}

}
