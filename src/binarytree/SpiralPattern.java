package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;

//Time Complexity : O(N)
public class SpiralPattern {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.left.left = new Node(40);
		root.left.left.right = new Node(45);
		print(root);
	}

	public static void print(Node root) {
		if (root != null) {
			List<Integer> list = new ArrayList<Integer>();
			Queue<Node> q = new LinkedList<Node>();
			int levelNodes = 0;
			boolean evenlevel = false;
			q.add(root);
			while (!q.isEmpty()) {
				levelNodes = q.size();
				list.clear();
				while (levelNodes > 0) {
					Node n = q.remove();
					list.add(n.data);
					if (n.left != null) {
						q.add(n.left);
					}
					if (n.right != null) {
						q.add(n.right);
					}
					levelNodes--;
				}
				if (evenlevel) {
					System.err.println(list);
					evenlevel = !evenlevel;
				} else {
					Collections.reverse(list);
					System.err.println(list);
					evenlevel = !evenlevel;
				}
			}
		}
	}

}
