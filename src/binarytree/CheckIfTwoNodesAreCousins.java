package binarytree;

import tree.Node;
public class CheckIfTwoNodesAreCousins {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node x1 = new Node(2);
		Node y1 = new Node(3);
		root.left = x1;
		root.right = y1;
		root.left.left = new Node(4);
		root.right.left = new Node(6);
		Node x2 = new Node(7);
		Node y2 = new Node(9);
		root.right.left.left = new Node(8);
		root.right.left.right = y2;
		root.left.left.left = x2;
		System.out.println("Node " + x1.data + " and Node " + y1.data + " are cousins??? " + areCousins(root, x1, y1));
		System.out.println("Node " + x2.data + " and Node " + y2.data + " are cousins??? " + areCousins(root, x2, y2));
	}

	public static boolean areCousins(Node root, Node x, Node y) {
		if (root != null) {
			if (getNodeHeight(root, x, 1) != getNodeHeight(root, y, 1)) {
				return false;
			}
			if (!areSiblings(root, x, y)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static int getNodeHeight(Node root, Node dest, int height) {
		if (root == null)
			return 0;
		if (root == dest)
			return height;
		int level = getNodeHeight(root.left, dest, height + 1);
		if (level != 0) {
			return level;
		}
		return getNodeHeight(root.right, dest, height + 1);
	}

	public static boolean areSiblings(Node root, Node x, Node y){
		if(root!=null){
			if ((root.left == x && root.right == y) || (root.right == x && root.left == y)
					|| areSiblings(root.left, x, y) || areSiblings(root.right, x, y)) {
				return true;
			}
		}
		return false;
	}
}
