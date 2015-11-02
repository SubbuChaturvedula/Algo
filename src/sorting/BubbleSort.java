package sorting;


public class BubbleSort {

	public static void main(String[] args) {
		int[] a = { 10, 2, 3, 16, -1, -5 };
		int[] b = bubbleSort(a);
		// System.err.println(" Hi");
		for (int x : b) {
			System.err.print(x + " ");
		}

		// recursiveBubbleSort(a, 0, a.length - 1);
		// for (int x : a) {
		// System.err.print(x + " ");
		// }
	}


	public static int[] bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {// outer forward
			System.err.println("printing loop val " + i);
			for (int j = 0; j < (a.length - 1) - i; j++) {// inner forward
				System.err.println("****inner printing loop val " + j + " *****");
				if (a[j] > a[j + 1]) {
					swap(j, j + 1, a);
				}
			}
		}
		return a;
	}

	public static int[] bubbleSort1(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {// outer backward
			System.err.println("printing loop val " + i);
			for (int j = (a.length - 1); j > (a.length - 1) - i; j--) {// inner backward
				System.err.println("****inner printing loop val " + j + " *****");
				if (a[j] < a[j - 1]) {
					swap(j, j - 1, a);
				}
			}
		}
		return a;
	}

	public static int[] bubbleSort2(int[] a) {
		for (int i = a.length - 1; i > 0; i--) { // outer backward
			System.err.println("printing loop val " + i);
			for (int j = 0; j < i; j++) { // inner forward
				System.err.println("****inner printing loop val " + j + " *****");
				if (a[j] > a[j + 1]) {
					swap(j, j + 1, a);
				}
			}
		}
		return a;
	}

	public static int[] bubbleSort3(int[] a) {
		for (int i = 0; i < a.length - 1; i++) { // outer forward
			System.err.println("printing outer loop val " + i);
			for (int j = (a.length - 1); j > i; j--) { // inner backward
				System.err.println("****printing inner loop val " + j + " *****");
				if (a[j] < a[j - 1]) {
					swap(j, j - 1, a);
				}
			}
		}
		return a;
	}

	public static int[] bubbleSort4(int a[]) {
		boolean flag = true;
		int j = 0;
		while (flag) {
			System.err.println(" Counter j value " + j);
			j++;
			flag = false;
			for (int i = 0; i < (a.length - j); i++) {
				System.err.println("****printing inner loop val " + i + " *****");
				if (a[i] > a[i + 1]) {
					swap(i, i + 1, a);
					flag = true;
				}
			}
		}
		return a;
	}

	public static void recursiveBubbleSort(int a[], int start, int finish) {
		if (start < finish) {
			if (a[start] > a[finish]) {
				swap(start, finish, a);
			}
			recursiveBubbleSort(a, start + 1, finish);
			recursiveBubbleSort(a, start, finish - 1);
		} else {
			return;
		}
	}

	public static void swap(int left, int right, int a[]) {
		a[left] = a[left] ^ a[right];
		a[right] = a[left] ^ a[right];
		a[left] = a[left] ^ a[right];
	}
}
