package binarytree;

import tree.Node;

public class CheckMirrorTree {

	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.left.right = new Node(3);
		root1.right = new Node(4);

		Node root2 = new Node(1);
		root2.right = new Node(2);
		root2.right.left = new Node(3);
		root2.left = new Node(4);

		System.err.println(" Is Mirror " + isMirror(root1, root2));
	}

	public static boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1.data != root2.data) {
			return false;
		}
		if (root1 != null && root2 == null || root1 == null && root2 != null) {
			return false;
		}
		return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}

	// Two binary trees are isomorphic if they have same structure. The values
	// of the nodes doesnt affect whether two trees are isomorphic or not.
	public static boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 != null && root2 == null || root1 == null && root2 != null) {
			return false;
		}
		return isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
	}
}
