package Sep15;

public class Pr16 {

	public static void main(String[] args) {
		CircularBuffer cb = new CircularBuffer(10);

		for (int i = 0; i < 4; i++) {
			cb.record(i);
		}

		System.out.println(cb);

		for (int i = 0; i < 10; i++) {
			System.out.println(cb.getLast(i));
		}
	}

}
