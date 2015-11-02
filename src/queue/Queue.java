package queue;

public class Queue {

	public int size;
	public int front;
	public int rear;
	public int[] queueArr;
	public int number;

	public Queue(int size) {
		this.size = size;
		queueArr = new int[size];
		rear = 0;
		front = 0;
	}

	public void insert(int item) {
		queueArr[rear++] = item;
		number++;
	}

	public int remove() {
		int item = queueArr[front++];
		System.err.print(item + " ");
		number--;
		return item;
	}

	public boolean isFull() {
		return (number == size);
	}

	public boolean isEmpty() {
		return (number == 0);
	}

	public static void main(String[] args) {
		Queue q = new Queue(4);
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(4);
		q.remove();
		q.remove();
		q.remove();
		q.remove();

	}
}
