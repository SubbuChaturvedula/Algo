package arrays;


public class MissingNumber {

	public static void main(String[] args) {
		int a[] = { 1, 2, 7, 6, 3, 4 };
		int range = 7;
		System.err.println(" The missing no is " + missingNumber(a, range));
	}

	public static int missingNumber(int a[], int range) {
		int x = 0;
		int y = 0;
		for (int i = 1; i <= range; i++) {
			x = x ^ i;
		}
		for (int i = 0; i < a.length; i++) {
			y = y ^ a[i];
		}
		return x ^ y;
	}
}
