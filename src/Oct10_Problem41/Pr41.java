package Oct10_Problem41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * <p>
 * This problem was asked by Facebook.
 * <p>
 * Given an unordered list of flights taken by someone, each represented as
 * (origin, destination) pairs, and a starting airport, compute the person's
 * itinerary. If no such itinerary exists, return null. If there are multiple
 * possible itineraries, return the lexicographically smallest one. All flights
 * must be used in the itinerary.
 * <p>
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'),
 * ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return
 * the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 * <p>
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting
 * airport 'COM', you should return null.
 * <p>
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')]
 * and starting airport 'A', you should return the list ['A', 'B', 'C', 'A',
 * 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
 * However, the first one is lexicographically smaller.
 */
public class Pr41 {

	private static final Logger LOG = Logger.getLogger(Pr41.class.getName());

	private static Pair getFlight(HashMap<String, List<Pair>> flightLegMap, String origin) {
		Pair result = null;

		var flightList = flightLegMap.get(origin);

		if (flightList != null && flightList.size() > 0) {
			var flight = flightList.get(0);
			if (flight != null) {
				flightList.remove(0);
				if (flightList.size() == 0) {
					flightLegMap.remove(origin);
				}
				result = flight;
			}
		}

		return result;
	}

	public static List<String> getItinerary(List<Pair> flightLegs, String startingAirport) {
		List<String> result = new ArrayList<>();
		HashMap<String, List<Pair>> flightLegMap = new HashMap<>();

		// put each flight leg into a map of origin->(origin,destination)
		for (var pair : flightLegs) {
			if (!flightLegMap.containsKey(pair.getOrigin())) {
				flightLegMap.put(pair.getOrigin(), new ArrayList<Pair>());
			}
			flightLegMap.get(pair.getOrigin()).add(pair);
		}
		// sort each entry in the map lexicographically by origin
		flightLegMap.keySet().forEach(origin -> {
			flightLegMap.get(origin).sort((p1, p2) -> p1.getOrigin().compareTo(p2.getOrigin()));

			LOG.info("Sorted flights for: " + origin + ": " + flightLegMap.get(origin));
		});

		// get the first flight
		var flight = getFlight(flightLegMap, startingAirport);
		var prevFlight = flight;
		// remove flights from the map in lexicographic order
		while (flight != null) {

			LOG.info("Current flight: " + flight.toString());

			result.add(flight.getOrigin());
			prevFlight = flight;
			flight = getFlight(flightLegMap, flight.getDestination());
		}
		// add the last flights destination to the result
		result.add(prevFlight.getDestination());

		// if flights remained in the map, the result will be null (no itinerary can be
		// reconstructed)
		if (flightLegMap.size() > 0) {
			result = null;
		}

		return result;
	}

	public static void printItinerary(List<Pair> flights, String startingAirport) {
		System.out.println("Starting airport: " + startingAirport);
		System.out.println("Flights: " + flights);
		List<String> itinerary = getItinerary(flights, startingAirport);
		if (itinerary != null) {
			System.out.println("Itinerary: " + itinerary);
		} else {
			System.out.println("No itinerary exists!");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		printItinerary(Arrays.asList(
				new Pair[] { Pair.build("A", "B"), Pair.build("A", "C"), Pair.build("B", "C"), Pair.build("C", "A") }),
				"A");

		printItinerary(Arrays.asList(new Pair[] { Pair.build("SFO", "HKO"), Pair.build("YYZ", "SFO"),
				Pair.build("YUL", "YYZ"), Pair.build("HKO", "ORD") }), "YUL");

		printItinerary(Arrays.asList(new Pair[] { Pair.build("SFO", "COM"), Pair.build("COM", "YYZ") }), "COM");

	}

}
