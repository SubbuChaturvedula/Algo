package binarysearchtree;

import tree.Node;

public class BSTImpl {
	public static Node root;

	public static Node search(Node n) {
		Node current = root;
		while (current != null) {
			if (current.data == n.data) {
				return current;
			} else if (n.data < current.data) {
				current = current.left;
			} else if (n.data > current.data) {
				current = current.right;
			}
		}
		return null;
	}

	public static void insert(int value) {
		Node n = new Node(value);
		if (root == null) {
			root = n;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (value < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = n;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = n;
					return;
				}
			}
		}
	}

	public static void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public boolean delete(int id) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current.data != id) {
			parent = current;
			if (current.data < id) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		// if i am here that means we have found the node
		// Case 1: if node to be deleted has no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.left != null && current.right != null) {
			// now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	public static Node getSuccessor(Node deleteNode) {
		Node successorParent = null;
		Node successor = null;
		Node current = deleteNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		// check if successor has the right child, it cannot have left child for
		// sure
		// if it does have the right child, add it to the left of
		// successorParent.
		if (successor != deleteNode.right) {
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		return successor;
	}
}
