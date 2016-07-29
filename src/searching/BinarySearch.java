package searching;

///binary search is log(n)
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = { 2, 5, 8, 10, 14, 44, 77, 78, 99 };
		int data = 10;
		int x=search(a, data);
		System.err.println(data + " Found at index "+x);
		// iterative
		System.err.println(data + " Found at index " + binarySearch(a, data));
	}

	public static int search(int a[],int data){
		return binarySearch(a, 0, a.length-1, data);
	}
	
	
	public static int binarySearch(int a[], int low, int high,int data){
		if(low>high) return -1;
		int mid=low+(high-low)/2;
		if(data==a[mid]){
			return mid;
		}else if (data < a[mid]){
			return binarySearch(a, low, mid-1, data);
		}else {
			return binarySearch(a, mid+1, high, data);
		}
	}

	// Iterative Approach
	public static int binarySearch(int[] a, int elementToBeSearched) {
		int first = 0;
		int last = a.length - 1;
		while (first < last) {
			int mid = first + (last - first) / 2;
			if (elementToBeSearched < a[mid]) {
				last = mid;
			} else if (elementToBeSearched > a[mid]) {
				first = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;

	}
}
