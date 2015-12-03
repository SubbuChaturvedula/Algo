package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tree.Node;

public class PrintVerticalOrderPath {

	private static Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
	private static List<Integer> list;
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		vertical(root, 0, false);
		print(map);
	}

	public static int vertical(Node root, int level, boolean left) {
		if (root != null) {
			level = vertical(root.right, ++level, true);
			if (map.get(level) != null) {
				List<Integer> list = map.get(level);
				list.add(root.data);
				map.put(level, list);
			} else {
				list = new ArrayList<>();
				list.add(root.data);
				map.put(level, list);
			}
			vertical(root.left, --level, false);
			return level;
		} else if (left) {
			return --level;
		} else {
			return ++level;
		}
	}

	public static void print(Map<Integer, List<Integer>> map) {
		for (Integer key : map.keySet()) {
			System.err.println(map.get(key));
		}
	}
}
