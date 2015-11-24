package sorting;

/*Best , Average,Worst Cases

*  Best Case        :    O(n log n)
* Average Case   :    O(n log n)
* Worst Case      :    O(n^2)
* */

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		int[] b = quickSort(0, a.length - 1, a);
		// System.err.println(" Hi");
		for (int x : b) {
			System.err.print(x + " ");
		}
	}

	private static int[] quickSort(int left, int right, int[] a) {
		int i = left;
		int j = right;
		int mid = left + (right - left) / 2;
		int pivot = a[mid];
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swapTest(i, j, a);
				i++;
				j--;
			}
		}
		if (i < right) {
			quickSort(i, right, a);
		}
		if (j > left) {
			quickSort(left, j, a);
		}
		return a;
	}

	public static void swap(int left, int right, int a[]) {
		a[left] = a[left] ^ a[right];
		a[right] = a[left] ^ a[right];
		a[left] = a[left] ^ a[right];
	}

	public static void swapTest(int i, int j, int a[]) {
		int tmp;
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
