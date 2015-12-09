package binarytree;

import tree.Node;

/*Do the preorder traversal, pass x as parameter.
While going down, at each level, keep reducing the x by 1
When x = 0 , the means you have reached to the nodes which are at x distance from root, Print them.*/
public class PrintNodesAtXDistanceFromRoot {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		print(root, 3);
	}

	public static void print(Node root, int x) {
		if (root != null) {
			if (x == 0) {
				System.err.print(root.data + " ");
			}
			print(root.left, --x);
			print(root.right, x);

		}
	}
}
