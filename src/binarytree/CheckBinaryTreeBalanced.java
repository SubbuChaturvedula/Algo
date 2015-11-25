package binarytree;

import tree.Node;

public class CheckBinaryTreeBalanced {
	/*
	 * Recursion Post order tra­ver­sal technique Travel all the way down to
	 * leaf nodes and then go up. while going up, cal­cu­late the left and right
	 * sub­tree height. If the dif­fer­ence between them is greater than 1,
	 * return –1. Else Max(leftHeight, rightHeight) +1 . Here you wont actu­ally
	 * cal­cu­late the height of the sub­trees by call­ing func­tion, instead
	 * you will store the height at each level and when you go one level up, you
	 * add one to it. So Time com­plex­ity is not O(N^2) but it will ne only
	 * O(N) but it will have space com­plex­ity as O(h) where h is the height of
	 * the tree
	 */
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		System.err.println(checkBalance(root));
		 root.right.right.right = new Node (40);
		 root.right.right.right.right = new Node (45);
		 
	}

	public static int isBalanced(Node root) {
		if (root == null) {
			return 0;
		}
		int leftH = isBalanced(root.left);
		if (leftH == -1) {
			return -1;
		}
		int rightH = isBalanced(root.right);
		if (rightH == -1) {
			return -1;
		}
		if (Math.abs(leftH - rightH) > 1) {
			return -1;
		}
		return 1 + Math.max(leftH, rightH);
	}

	public static boolean checkBalance(Node root) {
		int x = isBalanced(root);
		if (x > 0) {
			return true;
		} else {
			return false;
		}
	}

}
