package binarytree;

import java.util.Stack;

import tree.Node;

public class PreOrderIterative {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		preorder(root);
	}

	public static void preorder(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// First print the root node and then add left node
			while (root != null) {
				System.err.print(root.data + " ");
				s.push(root);
				root = root.left;
			}
			// check if Stack is emtpy, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack and go right to the tree
			// System.err.print(s.peek().data);
			root = s.pop();
			root = root.right;
		}
	}
}
