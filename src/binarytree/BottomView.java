package binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import tree.Node;
import tree.QueuePack;

public class BottomView {

	private static Map<Integer, Integer> ht = new TreeMap<Integer, Integer>();

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.right.right = new Node(8);
		bottomview(root, 0);
		display();
	}

	public static void bottomview(Node root, int level) {
		if (root != null) {
			Queue<QueuePack> q = new LinkedList<QueuePack>();
			q.add(new QueuePack(level, root));
			while (!q.isEmpty()) {
				QueuePack qp = q.remove();
				Node n = qp.node;
				int lvl = qp.level;
				ht.put(lvl, n.data);

				if (n.left != null) {
					q.add(new QueuePack(lvl - 1, n.left));
				}
				if (n.right != null) {
					q.add(new QueuePack(lvl + 1, n.right));
				}
			}
		}
	}

	public static void display() {
		for (Entry<Integer, Integer> entry : ht.entrySet()) {
			System.err.println("Level " + entry.getKey() + " Node " + entry.getValue());
		}
	}

}
