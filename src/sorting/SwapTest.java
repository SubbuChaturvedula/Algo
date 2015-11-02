package sorting;

public class SwapTest {

	public static void main(String[] args) {
		int n = factorial(5);
		// System.err.println(n);
	}

	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void swap(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.err.println(a + " " + b);
	}

}
