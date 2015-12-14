package binarytree;

import tree.Node;
public class BinarytreeIsSubTreeOfAnother {
	// Time Complexity : O(n)
	public static void main(String[] args) {
		Node rootA = new Node(1);
		rootA.left = new Node(2);
		rootA.right = new Node(4);
		rootA.left.left = new Node(3);
		rootA.right.right = new Node(6);
		rootA.right.left = new Node(5);
		Node rootB = new Node(4);
		rootB.left = new Node(5);
		rootB.right = new Node(6);
		System.out.println("Tree A ");
		print(rootA);
		System.out.println();
		System.out.println("Tree B ");
		print(rootB);
		String rootAInorder = inorder(rootA, "").toLowerCase();
		String rootBInorder = inorder(rootB, "").toLowerCase();
		String rootAPostorder = postorder(rootA, "").toLowerCase();
		String rootBPostorder = postorder(rootB, "").toLowerCase();
		if ((rootAInorder.contains(rootBInorder) && (rootAPostorder.contains(rootBPostorder)))) {
			System.out.println();
			System.out.println("One tree is subtree of another ");
		}
	}

	public static void print(Node root) {
		if (root != null) {
			print(root.left);
			System.out.print(root.data + " ");
			print(root.right);
		}
	}

	public static String inorder(Node root, String str) {
		if (root != null) {
			return inorder(root.left, str) + " " + root.data + " " + inorder(root.right, str);
		}
		return "";
	}

	public static String postorder(Node root, String str) {
		if (root != null) {
			return postorder(root.left, str) + " " + postorder(root.right, str) + " " + root.data;
		}
		return "";
	}
}
