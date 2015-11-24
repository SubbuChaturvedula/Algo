package arrays;

public class OddOccuringNumber {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7 };
		int x = findOddOccuranceInArray(a);

		System.err.println(" Number occuring odd number of time is " + x);
	}

	public static int findOddOccuranceInArray(int a[]) {
		int x = 0;
		for (int i = 0; i < a.length; i++) {
			x = x ^ a[i];
			System.err.println(x);
		}
		return x;
	}
}
