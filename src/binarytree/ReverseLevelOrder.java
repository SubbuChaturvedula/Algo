package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.Node;

public class ReverseLevelOrder {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);

		reverseLevelOrder(root);
	}

	public static void reverseLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> stack = new Stack<>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.remove();
			stack.add(node);

			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		while (!stack.isEmpty()) {
			System.err.print(stack.pop().data + " ");
		}
	}

}
