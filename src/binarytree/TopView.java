package binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import tree.Node;
import tree.QueuePack;

public class TopView {

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
		topview(root, 0);
		display();
		topView(root);
	}

	public static void topView(Node root) {
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}

		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + " ");
		}

		curr = root.right;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	public static void topview(Node root, int level) {
		if (root != null) {
			Queue<QueuePack> q = new LinkedList<QueuePack>();
			q.add(new QueuePack(level, root));
			while (!q.isEmpty()) {
				QueuePack qp = q.remove();
				Node n = qp.node;
				int lvl = qp.level;
				if (ht.containsKey(lvl)) {// means this level already visited

				} else { // means first time visiting level
					ht.put(lvl, n.data);
				}
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
