package binarytree;

import tree.Node;

public class BTFromInorderLevelorder {
	// int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
	// int[] levelOrder = { 1, 2, 3, 4, 5, 6, 7 };

	// First element in levelorder[] will be the root of the tree, here its 1.
	// Now the search element 1 in inorder[], say you find it at position i,

	// Suppose in previous step, there are X number of elements which are left
	// of ‘i’ (which will construct the leftsubtree), but these X elements will
	// not be in the consecutive in inorder[] so we will extract these
	// elements from levelorder[]
	// by maintaining their sequence and store it in an array say
	// newLeftLevel[].

	// similarly newRightLevel[]

	// once you find it, make note of elements which are left to i (this will
	// construct the leftsubtree) and elements which are right to i ( this will
	// construct the rightSubtree).

	// See this step above and recursively construct left subtree and link it
	// root.left and recursively construct right subtree and link it root.right.


	public static void main(String[] args) {
		int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] levelOrder = { 1, 2, 3, 4, 5, 6, 7 };
		Node root = constructTree(inOrder, levelOrder, 0, inOrder.length - 1);
		printInorder(root);
	}

	public static Node constructTree(int[] inOrder, int[] levelOrder, int start, int end) {
		if (start > end) {
			return null;
		}
		int rootVal = levelOrder[0];
		Node root = new Node(rootVal);
		if (start == end) {
			return root;
		}
		int inorderIndex = findIndex(inOrder, rootVal, start, end);
		int newLeftLevel[] = newLevelOrder(inOrder, levelOrder, start, inorderIndex - 1);
		// System.err.println(Arrays.toString(newLeftLevel));
		int newRightLevel[] = newLevelOrder(inOrder, levelOrder, inorderIndex + 1, end);
		// System.err.println(Arrays.toString(newRightLevel));
		root.left = constructTree(inOrder, newLeftLevel, start, inorderIndex - 1);
		root.right = constructTree(inOrder, newRightLevel, inorderIndex + 1, end);
		return root;
	}

	public static int[] newLevelOrder(int[] inOrder, int[] levelOrder, int start, int end) {
		int newLevel[] = new int[end - start + 1];
		int x = 0;
		for (int i = 0; i < levelOrder.length; i++) {
			if (findIndex(inOrder, levelOrder[i], start, end) != -1) {
				newLevel[x] = levelOrder[i];
				x++;
			}
		}
		return newLevel;
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
