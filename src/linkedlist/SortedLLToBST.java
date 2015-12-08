package linkedlist;

import tree.Node;

public class SortedLLToBST {

	public static linkedlist.Node head = null;

	public static void main(String[] args) {
		prepareLinkedList();
		System.err.println("Printing linked list ");
		print(head);
		System.err.println();
		Node root = convert(1, getSize());
		System.err.println("Printing Binary Tree ");
		print(root);
	}

	public static void prepareLinkedList() {
		head = new linkedlist.Node(1);
		head.next = new linkedlist.Node(2);
		head.next.next = new linkedlist.Node(3);
		head.next.next.next = new linkedlist.Node(4);
		head.next.next.next.next = new linkedlist.Node(5);
		linkedlist.Node tail = new linkedlist.Node(6);
		head.next.next.next.next.next = tail;
	}

	public static Node convert(int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		Node left = convert(low, mid - 1);
		Node root = new Node(head.value);
		root.left = left;
		head = head.next;
		Node right = convert(mid + 1, high);
		root.right = right;
		return root;
	}

	// get the size of linkedlist
	public static int getSize() {
		linkedlist.Node temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	// print linkedlist
	public static void print(linkedlist.Node head) {
		linkedlist.Node temp = head;
		while (temp != null) {
			System.err.print(temp.value + " ");
			temp = temp.next;
		}
	}

	// print binary tree
	public static void print(Node root) {
		if (root != null) {
			print(root.left);
			System.err.print(root.data + " ");
			print(root.right);
		}
	}

}
