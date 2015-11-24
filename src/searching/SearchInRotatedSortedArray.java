package searching;


public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int a[] = { 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8 };
		System.err.println(findElement(a, 5));
	}

	public static int findElement(int[] a, int data) {
		int index = rotatedSearch(a, 0, a.length - 1, data);
		return index;
	}

	public static int rotatedSearch(int a[], int start, int finish, int data) {
		if (start > finish) {
			return -1;
		}
		int mid = start + (finish - start) / 2;
		if (a[mid] == data) {
			return mid;
		}
		if (a[start] > a[mid]) {
			if (data >= a[start] && data <= a[mid]) {
				return rotatedSearch(a, start, mid - 1, data);
			} else {
				return rotatedSearch(a, mid + 1, finish, data);
			}
		} else {
			if (data >= a[mid] && data <= a[finish]) {
				return rotatedSearch(a, mid + 1, finish, data);
			} else {
				return rotatedSearch(a, start, mid - 1, data);
			}
		}
	}
}
