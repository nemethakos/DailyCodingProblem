package Problem78;

/**
 * <p>
 * Compares two values: a with b.
 * <ul>
 * <li>if a < b returns a negative integer
 * <li>if a == b returns 0
 * <li>if a > b returns a positive integer
 * </ul>
 * 
 * @param <T> the type of the values
 */
@FunctionalInterface
public interface Compare<T> {
	int compare(T a, T b);
}