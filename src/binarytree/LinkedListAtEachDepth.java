package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;

public class LinkedListAtEachDepth {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		List<linkedlist.Node> list = levelOrder(root);
		print(list);
	}

	public static List<linkedlist.Node> levelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		List<linkedlist.Node> list = new ArrayList<linkedlist.Node>();
		q.add(root);
		while (!q.isEmpty()) {
			int levelNodes = q.size();
			linkedlist.Node head = null;
			linkedlist.Node current = null;
			while (levelNodes > 0) {
				Node node = q.remove();
				linkedlist.Node llNode = new linkedlist.Node(node.data);
				if (head == null) {
					head = llNode;
					current = llNode;
				} else {
					current.next = llNode;
					current = current.next;
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				levelNodes--;
			}
			list.add(head);
		}
		return list;
	}

	public static void print(List<linkedlist.Node> list) {
		for (linkedlist.Node head : list) {
			linkedlist.Node temp = head;
			while (temp != null) {
				System.out.print("-->" + temp.value);
				temp = temp.next;
			}
			System.out.println();
		}
	}

}
