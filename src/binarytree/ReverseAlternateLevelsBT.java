package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;

public class ReverseAlternateLevelsBT {

	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		System.err.println("Original Tree :");
		print(root);
		System.err.println("-------------------------");
		System.err.println("Reverse Alternate Levels in Tree :");
		storeAlternateLevels(root, 0);
		Collections.reverse(list);
		reverseAlternateLevels(root, 0);
		print(root);
	}

	public static void storeAlternateLevels(Node root, int level) {
		if (root != null) {
			storeAlternateLevels(root.left, level + 1);
			if (level % 2 != 0) {
				list.add(root.data);
			}
			storeAlternateLevels(root.right, level + 1);
		}
	}

	public static void reverseAlternateLevels(Node root, int level) {
		if (root != null) {
			reverseAlternateLevels(root.left, level + 1);
			if (level % 2 != 0) {
				root.data = list.remove(0);
			}
			reverseAlternateLevels(root.right, level + 1);
		}
	}
	public static void print(Node root) {
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			int levelNodes = 0;
			while (!q.isEmpty()) {
				levelNodes = q.size();
				while (levelNodes > 0) {
					Node n = q.remove();
					System.err.print(n.data + " ");
					if (n.left != null) {
						q.add(n.left);
					}
					if (n.right != null) {
						q.add(n.right);
					}
					levelNodes--;
				}
				System.err.println();
			}
		}
	}

}
