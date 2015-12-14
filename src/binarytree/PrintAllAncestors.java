package binarytree;

import tree.Node;

public class PrintAllAncestors {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.left.left = new Node(6);
		root.right.right = new Node(8);
		Node nine = new Node(9);
		root.right.right.left = nine;
		print(root, nine);
	}

	public static boolean print(Node root, Node node) {
		if (root == null) {
			return false;
		}
		if (root.left == node || root.right == node || print(root.left, node) || print(root.right, node)) {
			System.err.print(root.data + " ");
			return true;
		}
		return false;
	}

}
