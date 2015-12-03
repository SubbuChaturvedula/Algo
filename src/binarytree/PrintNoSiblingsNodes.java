package binarytree;

import tree.Node;

public class PrintNoSiblingsNodes {
	// Note: sibling node is the node which has the same parent, so you need
	// to print the nodes who is a sin­gle child of his parent.

	// Do the inorder traversal.
	// check if node has only child, if yes then print that child.

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.left.left = new Node(6);
		root.right.right = new Node(8);
		root.right.right.left = new Node(9);
		print(root);
	}

	public static void print(Node root) {
		if (root != null) {
			print(root.left);

			if (root.left != null && root.right == null) {
				System.err.print(root.left.data + " ");
			}
			if (root.left == null && root.right != null) {
				System.err.print(root.right.data + " ");
			}
			print(root.right);
		}
	}

}
