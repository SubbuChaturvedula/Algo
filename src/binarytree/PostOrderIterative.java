package binarytree;

import java.util.Stack;

import tree.Node;

public class PostOrderIterative {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		postorder(root);
	}

	public static void postorder(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while (!s1.isEmpty()) {
			Node n = s1.pop();
			s2.push(n);
			if (n.left != null) {
				s1.push(n.left);
			}
			if (n.right != null) {
				s1.push(n.right);
			}
		}

		System.out.println("Postorder Traversal: ");
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}

}
