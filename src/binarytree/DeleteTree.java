package binarytree;

import tree.Node;

public class DeleteTree {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		// Node node =
		delete(root);

	}

	public static Node delete(Node root) {
		if (root != null) {
			delete(root.left);
			delete(root.right);
			System.err.println("Deleting node is " + root.data);
			root = null;
			return root;
		}
		return null;
	}
}
