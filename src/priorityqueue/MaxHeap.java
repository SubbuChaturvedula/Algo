package priorityqueue;



public class MaxHeap {

	public int[] a;
	public int heapsize = 0;

	public MaxHeap(int[] a) {
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



	public static void main(String[] args) {
		int a[] = { 79, 31, 6, 2, 5, 1, 4, 80 };
		MaxHeap heap = new MaxHeap(a);
		int k = 3;
		// System.err.println("Max element in the heap is " + heap.extractMax());
		System.err.println(k + "th Largest element in the Array is " + heap.kthLargest(k));
		// heap.printKLargest(k);
	}

	public void swap(int x, int y, int a[]) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public int kthLargest(int k) {
		buildheap();
		for (int i = 0; i < k - 1; i++) {
			extractMax();
		}
		return this.extractMax();

	}

	public void printKLargest(int k) {
		buildheap();
		for (int i = 0; i < k; i++) {
			System.err.println(a[i]);
		}
	}

	public int extractMax() {
		int max = a[0]; // extract the root
		a[0] = a[heapsize]; // replace the root with the last element in the heap
		a[heapsize] = 0; // set the last element as 0
		heapsize--; // reduce the position pointer
		heapify(a, 0, heapsize); // sink down the root to its correct position
		return max;
	}
}
