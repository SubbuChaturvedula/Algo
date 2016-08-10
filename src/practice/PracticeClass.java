package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PracticeClass {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(16);
		root.left.right = new Node(12);
		root.left.right.left = new Node(6);
		root.right.right = new Node(8);
		root.right.right.left = new Node(51);
		postorder(root);
		System.out.println();
		postorderIterative(root);
		System.out.println();
		System.out.println("==============");
		delete(root);
		System.out.println("==============");
		System.out.println(" is 8 present in the tree ? " + isPresent(root, 8));
		System.out.println("==============");
		System.out.println(" is 8 present ITERATIVE in the tree ? " + ispresent(root, 8));
		System.out.println("==============");
		System.out.println("Size of BT " + size(root));
		System.out.println("==============");
		System.out.println("Size of BT ITERATIVE " + sizeIterative(root));
		System.out.println();
		System.out.println("====Level Order Traversal is=========");
		levelorder(root);
		System.out.println("\n======Reverse Level ORDER IS ========");
		reverselevelorder(root);
		System.out.println("\n======MAX BT REcursive ========" + getMax(root));
		System.out.println("\n======MAX BT ITERATIVE ========" + getMaxIterative(root));
		System.out.println(" Full nodes are :");
		fullNodes(root);
		System.out.println();
		System.out.println("Siblings Check " + siblings(root, root.left, root.right));
		System.err.println("Height of node 6 " + heightOfNode(root, 6, 1));
	}

	public static int heightOfNode(Node root, int x, int height) {
		if (root != null) {
			if (root.data == x) {
				return height;
			}
			int level = heightOfNode(root.left, x, height + 1);
			if (level != 0) {
				return level;
			}
			return heightOfNode(root.right, x, height + 1);
		}
		return height;
	}

	public static boolean siblings(Node root, Node x, Node y) {
		if (root != null) {
			if (((root.left == x && root.right == y) || (root.left == y && root.right == x))
					|| siblings(root.left, x, y) || siblings(root.right, x, y)) {
				return true;
			}
		}
		return false;
	}
	public static void fullNodes(Node root) {
		if (root != null) {
			fullNodes(root.left);
			if (root.left != null && root.right != null) {
				System.out.print(root.data + " ");
			}
			fullNodes(root.right);
		}
	}
	public static int getMax(Node root){
		if(root!=null){
			return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
		}
		return 0;
	}

	public static int getMaxIterative(Node root) {
		int max = 0;
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.remove();
				if (max < n.data) {
					max = n.data;
				}
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
		}
		return max;
	}
	public static int reverselevelorder(Node root) {
		int count = 0;
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			Stack<Node> s = new Stack<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.remove();
				s.push(n);
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
			while (!s.isEmpty()) {
				System.out.print(s.pop().data + " ");
			}
		}
		return count;
	}
	public static int levelorder(Node root) {
		int count = 0;
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.remove();
				System.out.print(n.data + " ");
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
		}
		return count;
	}

	public static int size(Node root) {
		if (root != null) {
			return 1 + size(root.left) + size(root.right);
		}
		return 0;
	}

	public static int sizeIterative(Node root) {
		int count = 0;
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.remove();
				count++;
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
		}
		return count;
	}

	public static boolean isPresent(Node root, int x) {
		if (root != null) {
			if (root.data == x) {
				return true;
			}
			return isPresent(root.left, x) || isPresent(root.right, x);
		}
		return false;
	}

	public static boolean ispresent(Node root, int x) {
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.remove();
				if (n.data == x) {
					return true;
				}
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
		}
		return false;
	}

	public static void delete(Node root) {
		if (root != null) {
			delete(root.left);
			delete(root.right);
			System.out.println(" Deleting node " + root.data);
			root = null;
		}
	}

	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void inorderIterative(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			if (s.isEmpty()) {
				return;
			}
			root = s.pop();
			System.out.print(root.data + " ");
			root = root.right;
		}
	}

	public static void preorderIterative(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			while (root != null) {
				s.push(root);
				System.out.print(root.data + " ");
				root = root.left;
			}
			if (s.isEmpty()) {
				return;
			}
			root = s.pop();
			root = root.right;
		}
	}

	public static void postorderIterative(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while (!s1.isEmpty()) {
			Node n = s1.pop();
			s2.push(n);
			if (n.left != null) {
				s1.push(n.left);
			}
			if (n.right != null) {
				s1.push(n.right);
			}
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}
}

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
}

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
