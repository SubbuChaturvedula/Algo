package binarytree;

import tree.Node;

/*Distance(X, Y) = Distance(root, X) +Distance(root, Y) — 2*(Distance(root to LCA(X,Y)
where LCA(X,Y) = Lowest Common Ancestor of X,Y
In the above example if Distance(20,45) = 3
Distance(root, 20) = 2
Distance(root, 45) = 3
LCA(20, 45) = 10
Distance(root, 10) = 1
Distance(20,45) = 2+3 — 2*1 = 3*/

public class DistanceBetweenTwoNodes {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		Node twenty=new Node(20);
		root.left.left = twenty;
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		Node fortyFive=new Node(45);
		root.left.right.right = fortyFive;
		int x = distanceBetweenTwo(root, twenty, fortyFive);
		System.err.println("Distance between 20 & 45 is :" + x);
	}

	public static int distanceFromRootToNode(Node root, Node dest) {
		if (root != null) {
			int x = 0;
			if (root.data == dest.data || (x = distanceFromRootToNode(root.left, dest)) > 0|| (x = distanceFromRootToNode(root.right, dest)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public static int distanceBetweenTwo(Node root, Node x, Node y) {
		int rootToX = distanceFromRootToNode(root, x) - 1;
		System.err.println("Distance(root, 20) " + rootToX);
		int rootToY = distanceFromRootToNode(root, y) - 1;
		System.err.println("Distance(root, 45) " + rootToY);
		Node LCA = getLCA(root, x, y);
		System.err.println("LCA OF 20 & 45 is " + LCA.data);
		int distanceFromLCAToRoot = distanceFromRootToNode(root, LCA) - 1;
		System.err.println("Distance(root, 10) " + distanceFromLCAToRoot);
		int result = (rootToX + rootToY) - 2 * (distanceFromLCAToRoot);
		return result;
	}

	public static Node getLCA(Node root, Node x, Node y) {
		if (root != null) {
			if ((root.data == x.data) || (root.data == y.data)) {
				return root;
			}
			Node left = getLCA(root.left, x, y);
			Node right = getLCA(root.right, x, y);
			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
}
