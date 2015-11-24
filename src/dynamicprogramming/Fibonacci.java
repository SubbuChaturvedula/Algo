package dynamicprogramming;

public class Fibonacci {

	public static void main(String[] args) {
		System.err.println(fibDP(7));
		System.err.println(fibTopDown(7));
	}

	public static int fibRecur(int x) {
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		else {
			int f = fibRecur(x - 1) + fibRecur(x - 2);
			return f;
		}

	}

	public static int fibDP(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static int fibTopDown(int n) {
		int[] fib = new int[n + 1];
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (fib[n] != 0) {
			return fib[n];
		} else {
			fib[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
			return fib[n];
		}
	}
}
