package stack;

import java.util.Stack;

public class TrackMaxInStack {

	Stack<Integer> main = new Stack<Integer>();
	Stack<Integer> track = new Stack<Integer>();

	public void insert(int x) {
		if (main.isEmpty()) {
			main.push(x);
			track.push(x);
		} else {
			int a = track.peek();
			main.push(x);
			track.push(Math.max(a, x));
		}
	}

	public Integer remove() {
		if (!main.isEmpty()) {
			track.pop();
			return main.pop();
		}
		return 0;
	}

	public int getMax() {
		return track.peek();
	}

	public static void main(String[] args) {
		TrackMaxInStack i = new TrackMaxInStack();
		i.insert(4);
		i.insert(2);
		i.insert(14);
		i.insert(1);
		i.insert(18);
		System.out.println("Max Element is " + i.getMax());
		System.out.println("Removing Element " + i.remove());
		System.out.println("Max Element is " + i.getMax());
	}
}
// objective here is to keep track of maximum value in a stack of integers
// create another another Stack which will keep track of maximum

// if stack is empty, insert the number in both stacks

// check if number in Stack(track) is bigger than x
// which ever is bigger, insert it into Stack
