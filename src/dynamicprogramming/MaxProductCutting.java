package dynamicprogramming;

public class MaxProductCutting {

	public static void main(String[] args) {
		int n = 5;
		// int max = maxProductRecursion(n);
		// System.out.println("Maximum Product Cutting of " + n + "->" + max);
		maxProductDP(n);
	}

	public static void maxProductDP(int n) {
		int[] MPC = new int[n + 1];
		MPC[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			int mp = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				mp = Math.max(mp, Math.max(j * (i - j), j * MPC[i - j]));
			}
			MPC[i] = mp;
		}
		System.out.println("Dynamic Programming: Maximum product cutting in " + n + " is " + MPC[n]);
	}
	public static int maxProductRecursion(int n) {
		if (n == 0 || n == 1) {// base case
			return 0;
		}
		int max = -1;
		// make all possible cuts and get the maximum
		for (int i = 1; i < n; i++) {
			max = Math.max(max, Math.max(i * (n - i), i * maxProductRecursion(n - i)));
			// Either this cut will produce the max product OR we need to make further cuts
		}
		return max;
	}

}
