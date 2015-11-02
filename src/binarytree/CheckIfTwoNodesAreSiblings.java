package binarytree;

import tree.Node;

/**
 * 1.Given, root, Node x, Node y. 2.Check if x and y are childs of root. (root.left==x && root.right==y) ||root.left==y
 * && root.right==x) 3.if yes then return true. 4.Else make a recur­sive call to root.left and root.right
 *
 */
public class CheckIfTwoNodesAreSiblings {

	public boolean sameParents(Node root, Node x, Node y) {
		if (root == null) {
			return false;
		}
		if ((root.left == x && root.right == y) || root.left == y && root.right == x || sameParents(root.left, x, y)
				|| sameParents(root.right, x, y)) {
			System.err.println(root.data);
			return true;
		}
		return false;

	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(1);
		Node x1 = new Node(2);
		Node y1 = new Node(3);
		root.left = x1;
		root.right = y1;
		root.left.left = new Node(4);
		root.right.left = new Node(6);
		Node x2 = new Node(7);
		Node y2 = new Node(9);
		Node eight = new Node(8);
		root.right.left.left = eight;
		root.right.left.right = y2;
		root.left.left.left = x2;

		CheckIfTwoNodesAreSiblings i = new CheckIfTwoNodesAreSiblings();
		// System.out.println(
		// "Node " + x1.data + " and Node " + y1.data + " are siblings??? " + i.sameParents(root, x1, y1));
		System.err.println(
			"Node " + x2.data + " and Node " + y2.data + " are siblings??? " + i.sameParents(root, eight, y2));
	}

}
