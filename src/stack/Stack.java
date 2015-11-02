package stack;

public class Stack {

	public int size;
	public int[] stackArr;
	public int top;

	public Stack(int size) {
		this.size = size;
		stackArr = new int[size];
		top = -1;
	}

	public void push(int item) {
		stackArr[++top] = item;
	}

	public int pop() {
		int item = stackArr[top--];
		System.err.print(item + " ");
		return item;
	}

	public boolean isFull() {
		return (top == size - 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public static void main(String[] args) {
		Stack s = new Stack(4);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		s.pop();
		s.pop();
		s.pop();
		s.pop();

	}

}
