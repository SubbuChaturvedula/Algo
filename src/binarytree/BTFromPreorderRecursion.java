package binarytree;

/*Solution to the problem is similar to isBST Max-Min Solution.

Your root value can have any value between -∞ to + ∞, say it is 30 here, 
When you validate the right child of 30, it can take any value between 30 and + ∞. 
When you validate the left child of 30, it can take any value between — ∞ and 30. likewise
So the idea is Pass the minimum and maximum values between which the node’s value must lie.
Example: int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
First element in the preorder[] will definitely be the root, which is 20 here.
we start with the range minimum = Integer.MIN_VALUE and maximum = Interger.MAX_VALUE, 
so your root can take any value between this range.
So when putting the left node of 20(root), it must lie within the range to 
minimum = Integer.MIN_VALUE and maximum = 20, 
so check the next element in the preorder[], if it lies in this range, 
make it the left child to the root, else it must the the right chlid of the root and so on. 
Solve it recursively.
Time Complexity: O(n)*/
public class BTFromPreorderRecursion {
	public static int pindex = 0;
	public static void main(String[] args) {
		int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
		Node root = constructTree(preOrder, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		display(root);
	}

	public static Node constructTree(int[] preorder, int data, int min, int max) {
		if (pindex < preorder.length) {
			if (preorder[pindex] > min && preorder[pindex] < max) {
				Node root = new Node(data);
				pindex++;
				if (pindex < preorder.length) {
					// nodes lies between min and data will create left subtree
					root.left = constructTree(preorder, preorder[pindex], min, data);
					// nodes lies between data and max will create right subtree
					root.right = constructTree(preorder, preorder[pindex], data, max);
				}
				return root;
			}
		}
		return null;
	}
	public static void display(Node root) {
		if (root != null) {
			display(root.left);
			System.err.print(" " + root.data);
			display(root.right);
		}
	}

}
