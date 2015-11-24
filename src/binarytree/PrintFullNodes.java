package binarytree;

import tree.Node;

public class PrintFullNodes {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.right = new Node(8);
		printFullNodes(root);
	}

	public static void printFullNodes(Node root) {
		if (root != null) {
			printFullNodes(root.left);
			if (root.left != null && root.right != null) {
				System.err.print(root.data + " ");
			}
			printFullNodes(root.right);
		}
	}

}
