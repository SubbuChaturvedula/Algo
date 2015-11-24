package arrays;

// one form of Dutch National Flag Problem
public class Separate0And1 {

	public static void main(String[] args) {
		int a[] = new int[] { 0, 1, 1, 0, 0, 0, 1, 1 };
		int b[] = separate(a);
		for (int x : b) {
			System.err.print(x + " ");
		}
	}

	public static int[] separate(int a[]) {
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			while (a[left] == 0 && left < right) {
				left++;
			}
			while (a[right] == 1 && left < right) {
				right--;
			}
			if (left < right) {
				a[left] = 0;
				a[right] = 1;
				left++;
				right--;
			}
		}
		return a;
	}
}
