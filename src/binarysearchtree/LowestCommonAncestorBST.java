package binarysearchtree;

import tree.Node;

public class LowestCommonAncestorBST {

	public Node getLCABST(Node root, Node n1, Node n2) {
		if (root == null) {
			return null;
		}
		if (root.data > n1.data && root.data > n2.data) {
			return getLCABST(root.left, n1, n2);
		} else if (root.data < n1.data && root.data < n2.data) {
			return getLCABST(root.right, n1, n2);
		} else {
			return root;
		}
	}

	public Node getLCABST2(Node root, Node n1, Node n2) {
		while (root != null) {
			if (root.data > n1.data && root.data > n2.data) {
				root = root.left;
			} else if (root.data < n1.data && root.data < n2.data) {
				root = root.right;
			} else {
				return root;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(15);
		Node left = new Node(10);
		Node right = new Node(20);
		Node n1 = new Node(5);
		Node n2 = new Node(14);
		root.left = left;
		root.right = right;
		root.left.left = n1;
		root.left.right = new Node(13);
		root.left.right.left = new Node(12);
		root.left.right.right = n2;
		LowestCommonAncestorBST bst = new LowestCommonAncestorBST();
		Node lcaBST = bst.getLCABST2(root, n1, n2);
		System.err.println(" LCA OF " + n1.data + " & " + n2.data + " is " + lcaBST.data);
	}
}
