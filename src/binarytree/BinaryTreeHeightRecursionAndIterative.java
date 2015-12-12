package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.Node;

public class BinaryTreeHeightRecursionAndIterative {

	public static void main(String args[]) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.left.left.left = new Node(30);
		root.left.right.left = new Node(35);
		root.left.right.left.left = new Node(40);
		root.left.right.left.left.right = new Node(45);
		root.left.right.left.left.right.left = new Node(50);

		System.out.println("Height of the Tree Recursion is : " + getHeight(root));
		System.out.println("Height of the Tree Iterative is : " + getHeightIterative(root));
	}

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
		}
	}

	public static int getHeightIterative(Node root) {
		// use NULL as a marker at every level, so whenever we encounter null, we
		// will increment the height by 1
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			q.add(null);
			int height = 0;
			while (!q.isEmpty()) {
				Node node = q.poll();// check if n is null, if yes, we have reached to the end of the
				// current level, increment the height by 1, and add the another
				// null as marker for next level
				if (node == null) {// before adding null, check if queue is empty, which means we
					// have traveled all the levels
					if (!q.isEmpty()) {
						q.add(null);
					}
					height++;
				} else {
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				}
			}
			return height;
		}
		return 0;
	}
}
