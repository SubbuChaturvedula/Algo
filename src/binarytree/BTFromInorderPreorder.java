package binarytree;

import tree.Node;

public class BTFromInorderPreorder {
	// int [] inOrder = {2,5,6,10,12,14,15};
	// int [] pre­Order = {10,5,2,6,14,12,15};

	// First element in preorder[] will be the root of the tree, here its 10.
	// Now the search element 10 in inorder[], say you find it at position i,

	// once you find it, make note of elements which are left to i (this will
	// construct the leftsubtree) and elements which are right to i ( this will
	// construct the rightSubtree).

	// See this step above and recursively construct left subtree and link it
	// root.left and recursively construct right subtree and link it root.right.

	public static int pindex = 0;
	public static void main(String[] args) {
		int[] inOrder = { 2, 5, 6, 10, 12, 14, 15 };
		int[] preOrder = { 10, 5, 2, 6, 14, 12, 15 };
		Node root = constructTree(inOrder, preOrder, 0, inOrder.length - 1);
		printInorder(root);
	}

	public static Node constructTree(int[] inOrder, int[] preOrder, int start, int end) {
		if (start > end) {
			return null;
		}
		int rootVal = preOrder[pindex];
		pindex++;
		Node root = new Node(rootVal);
		if (start == end) {
			return root;
		}
		int inorderIndex = findIndex(inOrder, rootVal, start, end);
		root.left = constructTree(inOrder, preOrder, start, inorderIndex - 1);
		root.right = constructTree(inOrder, preOrder, inorderIndex + 1, end);
		return root;
	}
	public static int findIndex(int[] array, int data, int start, int end) {
		int index = -1;
		for (int i = start; i <= end; i++) {
			if(array[i]==data){
				index=i;
			}
		}
		return index;
	}

	public static void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print("  " + root.data);
			printInorder(root.right);
		}

	}

}
