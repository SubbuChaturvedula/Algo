package sorting;

/*Best , Average,Worst Cases

*  Best Case        :    O(n)
* Average Case   :    O(n^2)
* Worst Case      :    O(n^2)*/

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 7, 8, 5, 2, 4, 6, 3 };
		insertionSort(a);
		for (int x : a) {
			System.err.print(x + " ");
		}

	}

	public static void insertionSort(int a[]) {
		// a[1] is the marker
		// i moves forward j moves backward
		for (int i = 1; i < a.length; i++) {
			System.err.println(" Outer loop i value***" + i);
			int marker = a[i];
			for (int j = i; j > 0; j--) { // j will start where i will start
				System.err.println(" Inner loop j value.........." + j);
				if (marker < a[j - 1]) {
					swap(j, j - 1, a);
				}
			}
		}
	}

	public static void swap(int left, int right, int a[]) {
		a[left] = a[left] ^ a[right];
		a[right] = a[left] ^ a[right];
		a[left] = a[left] ^ a[right];
	}
}
