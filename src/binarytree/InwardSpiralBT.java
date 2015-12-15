package binarytree;

import tree.Node;

//Time Complexity : O(N)
public class InwardSpiralBT {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.left.left = new Node(40);
		root.left.left.right = new Node(45);
		printInwardSpiral(root);
	}

	public static void printInwardSpiral(Node root) {
		final int height = getHeight(root);
		int i;
		for (i = 0; i < (height / 2); i++) {
			printLevelLeftToRight(i + 1, 1, root);
			System.out.println();
			printLevelRightToLeft(height - i, 1, root);
			System.out.println();
		}
		if ((height % 2) == 1) {
			printLevelLeftToRight(i + 1, 1, root);
		}
		System.out.println();
	}
	public static void printLevelLeftToRight(final int desiredLevel, int currentLevel, final Node node) {
		if (desiredLevel == currentLevel) {
			System.out.print(node.data + " ");
			return;
		}

		if (node.left != null) {
			printLevelLeftToRight(desiredLevel, currentLevel + 1, node.left);
		}
		if (node.right != null) {
			printLevelLeftToRight(desiredLevel, currentLevel + 1, node.right);
		}
	}

	public static void printLevelRightToLeft(final int desiredLevel, int currentLevel, final Node node) {
		if (desiredLevel == currentLevel) {
			System.out.print(node.data + " ");
			return;
		}

		if (node.right != null) {
			printLevelRightToLeft(desiredLevel, currentLevel + 1, node.right);
		}
		if (node.left != null) {
			printLevelRightToLeft(desiredLevel, currentLevel + 1, node.left);
		}
	}

	public static int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
		}
	}
}
