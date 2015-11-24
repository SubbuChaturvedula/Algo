package binarytree;

import tree.Node;

public class MaxInBinaryTree {

	// Max will the Max(root, max element in left subtree, max element in right subtree)
	public int getMax(Node root) {
		if (root != null) {
			return max(root.data, getMax(root.left), getMax(root.right));
		}
		return 0;
	}

	public int max(int a, int b, int c) {
		System.err.println(a + " " + b + " " + c);
		return Math.max(a, Math.max(b, c));
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		Node n3 = new Node(5);
		root.left.right = n3;
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node n1 = new Node(8);
		root.left.left.left = n1;
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(20);
		root.left.right.left.left = new Node(11);
		Node n2 = new Node(30);
		root.left.right.left.right = n2;
		MaxInBinaryTree m = new MaxInBinaryTree();
		System.err.println("Max element in Binary Tree: " + m.getMax(root));
	}

}
