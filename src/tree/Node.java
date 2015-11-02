package tree;

public class Node {

	public Node left;
	public Node right;
	public int data;

	public Node(int value) {
		this.data = value;
	}

	public Node(Node left, int value, Node right) {
		this.data = value;
		this.left = left;
		this.right = right;
	}

	public int minValue(Node n) {
		while (n.left != null) {
			n = n.left;
		}
		return n.data;
	}

	public int maxValue(Node n) {
		while (n.right != null) {
			n = n.right;
		}
		return n.data;
	}

	public Node search(Node n, int value) {
		Node output = null;
		if (n.data == value || n == null) {
			output = n;
		} else if (value < n.data) {
			search(n.left, value);
		} else if (value > n.data) {
			search(n.right, value);
		}
		return output;
	}

	public void insert(Node n, int value) {
		if (value < n.data) {
			if (n.left != null) {
				insert(n.left, value);
			} else {
				n.left = new Node(value);
			}
		}
		if (value < n.data) {
			if (n.right != null) {
				insert(n.right, value);
			} else {
				n.right = new Node(value);
			}
		}
	}
}
