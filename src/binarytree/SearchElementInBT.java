package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.Node;

public class SearchElementInBT {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Does 4 exist in the tree isPresentRecursive: " + isPresentRecursive(root, 4));
		System.out.println("Does 4 exist in the tree isPresentIterative: " + isPresentIterative(root, 4));
	}

	public static boolean isPresentRecursive(Node root, int data) {
		if(root!=null){
			if(root.data==data){
				return true;
			}else{
				return isPresentRecursive(root.left, data) || isPresentRecursive(root.right, data);
			}
		}
		return false;
	}

	public static boolean isPresentIterative(Node root, int data) {
		Queue<Node> q = new LinkedList<Node>();
		if (root != null) {
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.remove();
				if (n.data == data) {
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
}
