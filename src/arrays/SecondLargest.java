package arrays;


public class SecondLargest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };
		int x = secondLargest(a);
		System.err.println(x);
	}

	public static int secondLargest(int a[]) {
		int firstLargest = a[0];
		int secondLargest = -1;
		for (int i = 0; i < a.length; i++) {
			if (firstLargest < a[i]) {
				secondLargest = firstLargest;
				firstLargest = a[i];
			} else if (secondLargest < a[i]) {
				secondLargest = a[i];
			}
		}
		return secondLargest;
	}
}
