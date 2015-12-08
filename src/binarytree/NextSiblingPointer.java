package binarytree;

public class NextSiblingPointer {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node n = provideSiblings(root);
		printLevel(n);
		System.out.println("");
		printLevel(n.left);
		System.out.println("");
		printLevel(n.left.left);
	}

	public static void printLevel(Node root) {
		while (root != null) {
			System.out.print(" " + root.data);
			root = root.nextSibling;
		}
	}


	public static Node provideSiblings(Node root) {
		if (root != null) {
			if (root.left != null) {// check if left node is not null  make the left node's sibling points to the right node of root
				root.left.nextSibling = root.right;
			}
			if (root.right != null) { // if root has right
				if (root.nextSibling != null) { // check root next sibling
					root.right.nextSibling = root.nextSibling.left; // if so assign root next sibling left
				}
			}
			provideSiblings(root.left);
			provideSiblings(root.right);
			return root;
		}
		return null;
	}
}

class Node {
	int data;
	Node left;
	Node right;
	Node nextSibling;

	public Node(int data) {
		this.data = data;
	}
}