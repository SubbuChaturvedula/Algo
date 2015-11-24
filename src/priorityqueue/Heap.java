package priorityqueue;


public class Heap {

	public int[] array;
	public int count;
	public int capacity;
	public int heapType;

	public Heap(int capacity, int heapType) {
		this.heapType = heapType;
		this.capacity = capacity;
		this.array = new int[capacity];
		this.count = 0;
	}

	public int getParent(int i) {
		if (i <= 0 || i >= this.count) {
			return -1;
		}
		return i - 1 / 2;
	}

	public int getLeftChild(int i) {
		int left = 2 * i + 1;
		if (left >= this.count) {
			return -1;
		}
		return left;
	}

	public int getRightChild(int i) {
		int right = 2 * i + 2;
		if (right >= this.count) {
			return -1;
		}
		return right;
	}

	public int getMaximum() {
		if (this.count == 0) {
			return -1;
		}
		return this.array[0];
	}

	public int deleteMax() {
		if (this.count == 0) {
			return -1;
		}
		int data = array[0];
		array[0] = array[count - 1];
		count--;
		percolateDown(0);
		return data;
	}

	// heapify-down
	public void percolateDown(int i) {
		int left, right, temp, max;
		left = getLeftChild(i);
		right = getRightChild(i);
		if (left != -1 && array[left] > array[i]) {
			max = left;
		} else {
			max = i;
		}
		if (right != -1 && array[right] > array[max]) {
			max = right;
		}
		if (i != max) {
			temp = array[i];
			array[max] = array[i];
			array[i] = temp;
		}
		percolateDown(max);
	}
	
	public void destoryHeap(){
		this.count = 0;
		this.array = null;
	}

	public void resizeHeap() {
		int[] oldArray = new int[this.capacity];
		System.arraycopy(this.array, 0, oldArray, 0, this.count - 1);
		this.array = new int[this.capacity * 2];
		if (this.array == null) {
			return;
		}
		for (int i = 0; i < this.capacity; i++) {
			this.array[i] = oldArray[i];
		}
		this.capacity *= 2;
		oldArray = null;
	}

	public void insert(int data) {
		int i;
		if (this.count == this.capacity) {
			resizeHeap();
		}
		this.count++;
		i = count - 1;
		while(i>=0 && data>array[(i-1)/2]){
			array[i] = array[(i - 1) / 2];
			i = i - 1 / 2;
		}
		array[i] = data;
	}
}
