package binarytree;

public class InOrderSuccessorBinaryTree {

	public static Node n = null;
	public static Boolean nodeFound = false;

	public Node inOrderSuccBiTree(Node root, Node x) {
		nodeFound = false;
		if (x.right != null) {
			Node temp = leftMostTreeNode(x.right);
			System.out.println("The In Order Successor for '" + x.data + "' is " + temp.data);
			return null;
		}
		return findRecur(root, x);
	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public Node findRecur(Node root, Node x) {
		if (root == null)
			return null;
		if (root == x || (n = findRecur(root.left, x)) != null || (n = findRecur(root.right, x)) != null) {

			if (n != null) {
				if (root.left == n) {
					nodeFound = true;
					System.out.println("The In Order Successor for '" + x.data + "' is " + root.data);
					return null;
				}

			}
			return root;
		}
		return null;
	}

	public Node leftMostTreeNode(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		nodeFound = true;
		return x;
	}

	public static void main(String args[]) {
		Node root = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		root.left = b;
		root.right = c;
		root.left.left = new Node('d');
		root.left.right = new Node('e');
		Node x = new Node('x');
		root.left.right.left = new Node('i');
		root.left.right.left.right = new Node('j');
		root.left.right.left.right.right = x;
		root.right.left = new Node('f');
		Node g = new Node('g');
		root.right.right = g;

		InOrderSuccessorBinaryTree i = new InOrderSuccessorBinaryTree();
		System.out.print("Tree : ");
		i.display(root);
		System.out.println();
		nodeFound = false;
		i.inOrderSuccBiTree(root, x);
		if (!nodeFound) {
			System.out.println("InOrder Successor of " + x.data + " is NULL");
		}
		nodeFound = false;
		i.inOrderSuccBiTree(root, root);
		if (!nodeFound) {
			System.out.println("InOrder Successor of " + root.data + " is NULL");
		}
		nodeFound = false;
		i.inOrderSuccBiTree(root, b);
		if (!nodeFound) {
			System.out.println("InOrder Successor of " + g.data + " is NULL");
		}
	}

}
class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
