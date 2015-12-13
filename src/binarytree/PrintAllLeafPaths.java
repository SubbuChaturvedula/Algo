package binarytree;

import tree.Node;
public class PrintAllLeafPaths {
	// Do the preOrder traversal.
	// Store the current node in an array, say Path[] and maintain the length
	// say pathLength.
	// check if you are at leaf node (both the left and right child of parent
	// will be null).
	// If not then keep traversing by making recursive calls to root.left
	// and root.right.
	// Pass the path and pathLen as parameter so that at each level have its
	// own copy of path and and its length.
	// If you hit the leaf node then print the array.

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(7);
		root.right.left = new Node(6);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		System.out.println("Printing All Paths From Root to Leaves :\n");
		printPaths(root, new int[10], 0);
	}

	public static void printPaths(Node root, int[] path, int pathLen) {
		if (root == null)
			return;
		path[pathLen++] = root.data;
		if (root.left == null && root.right == null) {
			print(path, pathLen);
		} else {
			printPaths(root.left, path, pathLen);
			printPaths(root.right, path, pathLen);
		}
	}

	public static void print(int[] path, int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
}
