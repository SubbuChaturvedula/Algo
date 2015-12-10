package binarytree;

import tree.Node;

public class MaxSumLeafToRoot {

	public static int maxSum = -1;
	public static Node maxLeaf = null;

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(8);
		maxsum(root, 0);
		System.out.println(" MAX Sum From LEAF TO ROOT is  : " + maxSum + " \n");
		System.out.print(" Path From LEAF TO ROOT is :");
		path(root, maxLeaf);
	}

	public static void maxsum(Node root, int sum) {
		if (root != null) {
			sum = sum + root.data;
			if (sum > maxSum && root.left == null && root.right == null) {
				maxLeaf = root;
				maxSum = sum;
			}
			maxsum(root.left, sum);
			maxsum(root.right, sum);
		}
	}

	public static boolean path(Node root, Node maxLeaf) {
		if (root != null) {
			if ((root == maxLeaf) || path(root.left, maxLeaf) || path(root.right, maxLeaf)) {
				System.out.print(" " + root.data);
				return true;
			}
		}
		return false;
	}
}
