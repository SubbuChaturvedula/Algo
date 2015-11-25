package arrays;

import tree.Node;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int [] a = {2,3,6,7,8,9,12,15,16,18,20};
		Node root=convert(a, 0, a.length-1);
		displayTree(root);
	}

	
	public static Node convert(int a[], int low,int high){
		if(low>high){
			return null;
		}
		int mid = low + (high - low) / 2;
		Node root = new Node(a[mid]);
		root.left = convert(a, low, mid - 1);
		root.right = convert(a, mid + 1, high);
		return root;
	}
	
	public static void displayTree(Node root){
		if(root!=null){
			displayTree(root.left);
			System.err.print(root.data+" ");
			displayTree(root.right);
		}
	}
}
