package binarysearchtree;

//What is Inorder Successor: Inorder successor of a node is the next
// node in the inorder traversal of the tree. For the last node in a tree,
// inorder successor will be NULL
///Time Complexity : O(h) , h — height of the tree
public class InorderSuccessorBSTWithParentLink {
	public static void main(String[] args) {
		BSTNode root = new BSTNode(10);
		root.left = new BSTNode(5);
		root.left.parent = root;
		root.right = new BSTNode(15);
		root.right.parent = root;
		root.left.left = new BSTNode(3);
		root.left.left.parent = root.left;
		root.right.left = new BSTNode(17);
		root.right.left.parent = root.right;
		BSTNode a = new BSTNode(7);
		BSTNode eight = new BSTNode(8);
		a.right = eight;
		eight.parent = a;
		root.left.right = a;
		root.left.right.parent = root.left;
		System.out.print(" Tree : ");
		display(root);
		System.out.println();
		BSTNode x = null;
		// BSTNode x = inorderSuccessor(root, eight);
		// if(x!=null){
		// System.out.println("InOrder Successor of " + eight.data + " is " +
		// x.data);
		// } else {
		// System.out.println("InOrder Successor of " + eight.data + " is
		// NULL");
		// }
		x = inorderSuccessor(root, a);
		if (x != null) {
			System.out.println("InOrder Successor of " + a.data + " is " + x.data);
		} else {
			System.out.println("InOrder Successor of " + a.data + " is NULL");
		}
	}



	public static BSTNode inorderSuccessor(BSTNode root, BSTNode x) {
		// if the right child of x is not null then inOrder successor will the
		// left most node in
		// the right sub tree of x.
		if (x.right != null) {
			return leftMostNode(x.right);
		}
		BSTNode parent = x.parent;
		while (parent != null && x == parent.right) {
			x = parent;
			parent = parent.parent;
		}
		return parent;
	}
	public static BSTNode leftMostNode(BSTNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void display(BSTNode root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

}

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode parent;

	public BSTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
