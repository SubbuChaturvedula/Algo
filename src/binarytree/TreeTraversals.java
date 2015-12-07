package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.Node;

public class TreeTraversals {

	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.err.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void preorder(Node root) {
		if (root != null) {
			System.err.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.err.print(root.data + " ");
		}
	}

	public static void BFS(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.remove();
			System.err.print(node.data + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	public static void DFS(Node root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.err.print(node.data + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}

		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;

		System.err.println("Inorder Traversal is :");
		inorder(root);
		System.err.println();
		System.err.println("Preorder Traversal is :");
		preorder(root);
		System.err.println();
		System.err.println("Postorder Traversal is :");
		postorder(root);
		System.err.println();
		System.err.println("BFS OR Level Order Traversal is :");
		BFS(root);
		System.err.println();
		System.err.println("DFS is :");
		DFS(root);
	}
}
