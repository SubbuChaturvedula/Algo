package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;

// 50 76 54 72 67 
public class RightView {
	
	private static Node root = null;

	public static void main(String[] args) {
		int[] A = { 50, 17, 76, 9, 23, 54, 14, 19, 72, 12, 67 };
		root = buildBST(root, A);
		System.out.println("printing inorder: ");
		printBST(root);
		System.out.println();
		printLeftNRightViewOfBT(root);
	}

	public static void printLeftNRightViewOfBT(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		List<Node> rightView = new ArrayList<Node>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node n = queue.remove();
				if (i == 0) {
					rightView.add(n);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
				if (n.left != null) {
					queue.add(n.left);
				}
			}
		}

		System.err.println("Printing right view: ");
		for (Node Node : rightView) {
			System.out.print(Node.data + " ");
		}
		System.out.println();
	}

	public static void printBST(Node Node) {
		if (Node == null) {
			return;
		}
		if (Node.left != null) {
			printBST(Node.left);
		}
		System.out.print(Node.data + " ");
		if (Node.right != null) {
			printBST(Node.right);
		}
	}

	public static Node buildBST(Node Node, int[] A) {
		int len = A.length;
		for (int i = 0; i < len; i++) {
			Node = insertIntoBST(Node, A[i]);
		}
		return Node;
	}

	private static Node insertIntoBST(Node Node, int value) {
		if (Node == null) {
			return new Node(value);
		}
		if (value <= Node.data) {
			Node.left = insertIntoBST(Node.left, value);
		} else {
			Node.right = insertIntoBST(Node.right, value);
		}
		return Node;
	}
}





