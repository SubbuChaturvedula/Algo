package binarysearchtree;

//Case 1 : If the x has a right child then its inorder successor will the left most element in the right sub tree of x.

//Case 2: If the x doesn’t have a right child then its inorder successor will the 
//one of its ancestors, use the binary search technique to find the node x, start from the root, 
//if root is bigger than the x then go left, if root is less than x, go right. 
//while traveling whenever you go left , store the node and call it successor.

//Case 3: if x is the right most node in the tree then its inorder successor will be NULL.
public class InOrderSuccessorBST {
	public Node findInOrderSuccessor(Node root, Node x){
		if(x.right!=null){
			return leftMostTreeNode(x.right);
		}
		Node successor = null;
		while(root!=null){			
			if(root.data > x.data){
				successor = root;
				root = root.left;
			} else if (root.data < x.data) {
				root = root.right;
			} else {
				return successor;
			}
		}
		return null;		
	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public static void main(String args[]) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(5);
		root.left.left.left = new Node(1);
		Node a = new Node(7);
		root.left.left.right = a;
		Node eight = new Node(8);
		root.left.left.right.right = eight;
		root.right.left = new Node(17);
		root.right.right = new Node(25);
		InOrderSuccessor b = new InOrderSuccessor();
		System.out.print(" Tree : ");
		b.display(root);
		System.out.println();
		Node x = b.findInOrderSuccessor(root, eight);
		if (x != null) {
			System.out.println("InOrder Successor of " + eight.data + " is " + x.data);
		} else {
			System.out.println("InOrder Successor of " + eight.data + " is NULL");
		}
		x = b.findInOrderSuccessor(root, root);
		if (x != null) {
			System.out.println("InOrder Successor of " + root.data + " is " + x.data);
		} else {
			System.out.println("InOrder Successor of " + root.data + " is NULL");
		}
	}

	public Node leftMostTreeNode(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}