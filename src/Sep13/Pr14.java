package Sep13;

public class Pr14 {

	public static double piApproximation(int numPoints) {
		double pi = 0;
		int pointsInQuadrant = 0;

		for (int i = 0; i < numPoints; i++) {
			double x = Math.random();
			double y = Math.random();
			double distance = x * x + y * y;
			if (distance <= 1) {
				pointsInQuadrant++;
			}
		}

		pi = (4.0 * pointsInQuadrant) / numPoints;

		return pi;
	}

	public static void main(String... args) {
		for (int i = 10_000_000; i <= 100_000_000; i += 10_000_000) {
			double approxPi = piApproximation(i);
			System.out.format("Points: %d, Pi~ %f, distance:%f%n", i, approxPi, Math.abs(Math.PI-approxPi));
		}
	}

}
