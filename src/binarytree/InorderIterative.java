package binarytree;

import java.util.Stack;

import tree.Node;
public class InorderIterative {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		inorder(root);
	}

	public static void inorder(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// Go to the left extreme insert all the elements to stack
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			// check if Stack is empty, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack , print it and add the nodes at
			// the right to the Stack
			root = s.pop();
			System.err.print(root.data + " ");
			root = root.right;
		}
	}
}
