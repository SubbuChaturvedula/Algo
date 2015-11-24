package arrays;

// one form of Dutch National Flag Problem
public class SeparateEvenNOdd {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = separate(a);
		for (int x : b) {
			System.err.print(x + " ");
		}
	}

	public static int[] separate(int a[]) {
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			while (a[left] % 2 == 0 && left < right) {
				left++;
			}
			while (a[right] % 2 == 1 && left < right) {
				right--;
			}
			if (left < right) {
				a[left] = a[left] ^ a[right];
				a[right] = a[left] ^ a[right];
				a[left] = a[left] ^ a[right];
				left++;
				right--;
			}
		}
		return a;
	}
}
