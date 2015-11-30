package dynamicprogramming;

public class StairsClimbing {

	public static void main(String[] args) {
		int n = 3;
		int[] dyn = new int[n + 1];
		int x = possibleWays(n, dyn);
		System.err.println("No of ways to climb the stairs : " + x);
	}

	public static int possibleWays(int n, int[] dyn) {
		if (n < 1) {
			return 0;
		}
		if (dyn[n] > 0) {
			return dyn[n];
		}
		return 1 + possibleWays(n - 1, dyn) + possibleWays(n - 2, dyn) + possibleWays(n - 3, dyn);
	}
}
