package binarysearchtree;

public class TwoBSTIdentical extends BSTImpl {

	public static void main(String[] args) {

	}

	public static boolean identical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
			return false;
		} else if (root1.data == root2.data) {
			return identical(root1.left, root2.left) && identical(root1.right, root2.right);
		} else {
			return false;
		}
	}

}
