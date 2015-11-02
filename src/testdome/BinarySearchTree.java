package testdome;

class Node {

	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class BinarySearchTree {

	public static boolean isValidBST(Node root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValidBST(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.value <= min || node.value >= max)
			return false;
		return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);

		System.out.println(isValidBST(n2));
	}
}