package stack;

import java.util.Stack;

public class ImplementQueueUsingStack {
	Stack<Integer> stack1 = new Stack<>(); // act as back of the Queue
	Stack<Integer> stack2 = new Stack<>(); // act as the front of the Queue

	public void moveItems(Stack<Integer> s1, Stack<Integer> s2) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}

	public void push(int x) {// push into stack 1
		stack1.push(x);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			moveItems(stack1, stack2);
		}
		return stack2.pop(); // pop from stack 2
	}

	public int peek() {
		if (stack2.isEmpty()) {
			moveItems(stack1, stack2);
		}
		return stack2.peek();// peek from stack 2
	}

	public static void main(String[] args) {
		ImplementQueueUsingStack q = new ImplementQueueUsingStack();
		q.push(10);
		q.push(20);
		q.push(30);
		System.out.println("POP from Queue " + q.pop());
	}

}
