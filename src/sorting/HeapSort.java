package sorting;

public class HeapSort {

	public int[] a;
	public int heapsize = 0;
	public HeapSort(int[] a) {
		this.a = a;
		this.heapsize = a.length - 1;
	}

	// heapify
	public void heapify(int a[], int i, int heapsize) {
		int l, r, max;
		l = 2 * i;
		r = 2 * i + 1;
		if (l <= heapsize && a[l] > a[i]) {
			max = l;
		} else {
			max = i;
		}
		if (r <= heapsize && a[r] > a[max]) {
			max = r;
		}
		if (i != max) {
			swap(i, max, a);
			heapify(a, max, heapsize);
		}
	}

	// buildheap
	public void buildheap() {
		int length = a.length - 1;
		for (int i = length / 2; i >= 0; i--) {
			heapify(a, i, length);
		}
	}

	// heapsort
	public void heapsort(int a[]) {
		buildheap();
		for (int i = heapsize; i >= 0; i--) {
			swap(0, heapsize, a);
			heapsize--;
			heapify(a, 0, heapsize);
		}
	}

	public static void main(String[] args) {
		int a[] = { 7, 3, 6, 2, 5, 1, 4, 8 };
		HeapSort heapSort = new HeapSort(a);
		heapSort.heapsort(a);
		System.err.println("After sorting :");
		for (int x : a) {
			System.err.print(x + " ");
		}

	}

	public void swap(int x, int y, int a[]) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}



}
