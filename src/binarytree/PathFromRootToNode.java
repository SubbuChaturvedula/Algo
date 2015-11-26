package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.Node;

public class PathFromRootToNode {
	// Time Complexity : O(n)

	public static List<Integer> path = new ArrayList<Integer>();


	public static boolean pathFromNodeTo(Node root, Node dest) {
		if (root == null) {
			return false;
		}
		if (root == dest || pathFromNodeTo(root.left, dest) || pathFromNodeTo(root.right, dest)) {
			path.add(root.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		Node n1 = new Node(4);
		root.left.left = n1;
		root.left.right = new Node(5);
		Node n2 = new Node(8);
		root.left.right.right = n2;
		root.left.right.left = new Node(7);
		pathFromNodeTo(root, n2);
		Collections.reverse(path);
		System.err.print(path);
	}
}
