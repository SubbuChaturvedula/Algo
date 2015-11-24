package arrays;

///Magic Index — Find Index In Sorted Array Such That A[i] = i.
///Bet­ter solution would Modify the Binary Search — Time Com­plex­ity O(logN).
public class MagicIndex {

	public static void main(String[] args) {
		int[] a = { -1, 0, 1, 2, 4, 10 };
		System.err.println(findMagicIndex(a, 0, a.length - 1));
	}

	public static int findMagicIndex(int a[], int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == a[mid]) {
				return mid;
			} else if (mid < a[mid]) {
				return findMagicIndex(a, low, mid - 1);
			} else {
				return findMagicIndex(a, mid + 1, high);
			}
		}
		return -1;
	}
}
