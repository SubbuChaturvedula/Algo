package sorting;

/*Best , Average,Worst Cases
*  Best Case        :    O(n^2)
* Average Case   :    O(n^2)
* Worst Case      :    O(n^2)

*/

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 7, 8, 5, 2, 4, 6, 3 };
		selectionSort(a);
		// printArray(a);
	}

	public static void selectionSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.err.println(" Outer loop i value***" + i);
			int min = i;
			printArray(a);
			for (int j = i + 1; j < a.length; j++) {
				System.err.println(" Inner loop j value.........." + j);
				if (a[j] < a[min]) {
					swap(j, min, a);
				}
				printArray(a);
			}
		}
	}

	public static void swap(int left, int right, int a[]) {
		a[left] = a[left] ^ a[right];
		a[right] = a[left] ^ a[right];
		a[left] = a[left] ^ a[right];
	}

	public static void printArray(int a[]) {
		for (int x : a) {
			System.err.print(x + " ");
		}
		System.err.println();
	}
}
