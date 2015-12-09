package binarytree;

public class NextSiblingPointer {

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		BTNode n = provideSiblings(root);
		printLevel(n);
		System.out.println("");
		printLevel(n.left);
		System.out.println("");
		printLevel(n.left.left);
	}

	public static void printLevel(BTNode root) {
		while (root != null) {
			System.out.print(" " + root.data);
			root = root.nextSibling;
		}
	}


	public static BTNode provideSiblings(BTNode root) {
		if (root != null) {
			if (root.left != null) {// check if left BTNode is not null make the
									// left BTNode's sibling points to the right
									// BTNode of root
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

class BTNode {
	int data;
	BTNode left;
	BTNode right;
	BTNode nextSibling;

	public BTNode(int data) {
		this.data = data;
	}
}