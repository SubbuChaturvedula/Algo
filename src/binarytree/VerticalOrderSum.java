package binarytree;

import java.util.Map;
import java.util.TreeMap;

import tree.Node;

public class VerticalOrderSum {

	public static Map<Integer, Integer> map = new TreeMap<>();
	public static int level;

	public Node vertical(Node root, int level) {
		if (root == null) {
			return null;
		}
		Node x = vertical(root.left, --level);
		if (x == null) {
			level++;
		}
		if (map.get(level) != null) {
			int y = map.get(level);
			map.put(level, root.data + y);
		} else {
			map.put(level, root.data);
		}
		return vertical(root.right, ++level);
	}

	public void printResult(Map<Integer, Integer> ht) {
		for (int keys : ht.keySet()) {
			System.out.println("Level " + keys + " Sum : " + ht.get(keys));
		}
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		VerticalOrderSum p = new VerticalOrderSum();
		p.vertical(root, 0);
		p.printResult(map);
	}

}
