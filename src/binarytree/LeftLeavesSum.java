package binarytree;

import tree.Node;

//Do the inorder traversal
//check if it's a leaf and it should be left node by comparing with its parent
//If yes then add it to the sum.

public class LeftLeavesSum {
	private static int sum = 0;
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(10);
		root.left.right = new Node(12);
		root.left.right.left = new Node(6);
		root.right.right = new Node(8);
		root.right.right.left = new Node(5);
		sum(root, root);
		System.err.println("Left Leaves Sum is :" + sum);
	}

	public static void sum(Node root, Node parent) {
		if (root != null) {
			sum(root.left, root);
			if (root.left == null && root.right == null && root == parent.left) {
				sum = sum + root.data;
			}
			sum(root.right, root);
		}
	}

}
