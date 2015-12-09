package binarytree;

import tree.Node;

///What does Distance means : It means num­ber of edges between two nodes.
public class DistanceFromRootToNode {
	// Time Complexity : O(n)

	public static int distanceFromRoot(Node root, Node dest) {
		if (root != null) {
			int x = 0;
			if ((root.data == dest.data) || (x = distanceFromRoot(root.left, dest)) > 0 || (x = distanceFromRoot(root.right, dest)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
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
		int x = distanceFromRoot(root, n2);
		System.err.println("Distance from Root (1) to Node (8) is :" + (x - 1));
	}
}
