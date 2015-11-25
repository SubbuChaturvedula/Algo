package binarytree;

import tree.Node;

public class ExistsPathSum {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		hasPath(root, 10, "");
	}

	public static void hasPath(Node root, int sum, String path) {
		if (root != null) {
			if (root.data > sum) {
				return;
			} else {
				path = path + " " + root.data;
				sum = sum - root.data;
				if (sum == 0) {
					System.err.println(path);
				}
			}
			hasPath(root.left, sum, path);
			hasPath(root.right, sum, path);
		}
	}

}
