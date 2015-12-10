package binarysearchtree;

import tree.Node;

public class IS_BST {

	public static Node prevNode = null;

	public int minValue(Node n) {
		while (n.left != null) {
			n = n.left;
		}
		return n.data;
	}

	public int maxValue(Node n) {
		while (n.right != null) {
			n = n.right;
		}
		return n.data;
	}

	/**
	 * Recursive helper -- checks if a tree is a BST using minValue() and maxValue() (not efficient). runs slowly since
	 * it traverses over some parts of the tree many times.
	 */
	public boolean isBST(Node node) {
		if (node == null) {
			return true;
		}

		// do the subtrees contain values that do not agree with the node?
		if (node.left != null && maxValue(node.left) > node.data) {
			return false;
		}

		if (node.right != null && minValue(node.right) <= node.data) {
			return false;
		}

		// check that the subtrees themselves are ok
		return (isBST(node.left) && isBST(node.right));
	}

	/**
	 * Tests if a tree meets the conditions to be a binary search tree (BST). Uses the efficient recursive helper.
	 */
	public boolean isBST2() {
		return (isBST2(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/**
	 * Efficient BST helper -- Given a node, and min and max values, recurs down the tree to verify that it is a BST,
	 * and that all its nodes are within the min..max range. Works in O(n) time -- visits each node only once.
	 */
	public boolean isBST2(Node node, int min, int max) {
		if (node == null) {
			return (true);
		} else {

			// left should be in range min...node.data
			boolean leftOk = isBST2(node.left, min, node.data);

			// if the left is not ok, bail out
			if (!leftOk)
				return (false);

			// right should be in range node.data+1..max
			boolean rightOk = isBST2(node.right, node.data + 1, max);

			return (rightOk);
		}
	}

	// The max-Min solution
	public boolean isBST3(Node root, int min, int max) {
		if (root != null) {
			if (root.data > max || root.data < min) {
				return false;
			}
			return isBST2(root.left, min, root.data) && isBST2(root.right, root.data, max);
		} else {
			return true;
		}
	}

	// inorder
	public boolean isBST4(Node root) {
		if (root != null) {
			if (!isBST4(root.left)) {
				return false;
			}
			if (prevNode != null && prevNode.data >= root.data) {
				return false;
			}
			prevNode = root;
			return isBST4(root.right);
		}
		return true;
	}
}
