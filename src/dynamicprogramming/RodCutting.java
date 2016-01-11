package dynamicprogramming;

public class RodCutting {

	public static void main(String[] args) {
		int[] value = { 1, 5, 8, 9 };
		int x = profit(value, 1);
		System.out.println(x);
	}

	public static int profit(int[] value, int length) {
		if (length <= 0)
			return 0;
		// either we will cut it or don't cut it
		int max = -1;
		for (int i = 0; i < length; i++)
			max = Math.max(max, value[i] + profit(value, length - (i + 1)));
		return max;
	}
}
