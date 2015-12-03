package binarytree;

import tree.Node;

//Do the Pre­Order Traversal.
//Start­ing from the root, swap the left and right childs.
//Recur­sively call the same pro­ce­dure in the left­sub­tree and right subtree.
public class MirrorTree {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		mirror(root);
	}

	public static void mirror(Node root) {
		print(root);
		System.err.println();
		Node mirror = mirrorTree(root);
		print(mirror);
	}

	public static void print(Node root) {
		if (root != null) {
			print(root.left);
			System.err.print(root.data + " ");
			print(root.right);
		}
	}

	public static Node mirrorTree(Node root) {
		if(root!=null){
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			mirrorTree(root.right);
			mirrorTree(root.left);
		}
		return root;
	}
}
