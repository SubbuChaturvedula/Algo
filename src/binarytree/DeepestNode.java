package binarytree;

import tree.Node;

public class DeepestNode {

	private static int deepestLevel;
	private static int value;

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);

		System.err.println(findDeepest(root));
		// System.err.println(deepestLevel);
	}

	public static int findDeepest(Node root) {
		find(root, 0);
		return value;
	}

	public static int findDeepestLeft(Node root) {
		find(root, 0, true);
		return value;
	}

	public static void find(Node root, int level) {
		if (root != null) {
			find(root.left, ++level);
			if (deepestLevel < level) {
				deepestLevel = level;
				value = root.data;
			}
			find(root.right, level);
		}
	}

	public static void find(Node root, int level, boolean left) {
		if (root != null) {
			find(root.left, ++level, true);
			if (deepestLevel < level) {
				deepestLevel = level;
				value = root.data;
			}
			find(root.right, level, false);
		}
	}
}
