package stack;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);

		reverseStack(s);

		for (int x : s) {
			System.err.print(x + " ");
		}
	}

	public static void reverseStack(Stack<Integer> s) {
		if (s.isEmpty()) {
			return;
		} else {
			int temp = s.pop();
			reverseStack(s);
			appendStack(s, temp);
		}
	}

	public static void appendStack(Stack<Integer> s, int a) {
		if (s.isEmpty()) {
			s.push(a);
			return;
		} else {
			int temp = s.pop();
			appendStack(s, a);
			s.push(temp);
		}
	}
}
