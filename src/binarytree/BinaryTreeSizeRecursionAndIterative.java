package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.Node;

public class BinaryTreeSizeRecursionAndIterative {

	public static void main(String args[]) {
		Node root = new Node(5);
		root.left = new Node(15);
		root.right = new Node(25);
		root.left.left = new Node(20);
		root.left.right = new Node(30);
		root.right.left = new Node(2);
		root.right.right = new Node(10);

		System.out.println("Size of the Tree is : " + getSize(root));
		System.out.println("Size of the Tree is : " + getSizeIterative(root));
	}

	private static int getSize(Node root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + getSize(root.left) + getSize(root.right);
		}
	}

	public static int getSizeIterative(Node root) {
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			int size = 0;
			while (!q.isEmpty()) {
				Node node = q.poll();
				size++;
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			return size;
		}
		return 0;
	}
}
