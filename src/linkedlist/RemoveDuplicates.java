package linkedlist;

import java.util.Hashtable;

public class RemoveDuplicates {
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(2);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(4);
		n.next.next.next.next.next = new Node(4);
		n.next.next.next.next.next.next = new Node(2);
		display(n);
		Node after = removeduplicates(n);
		display(after);
	}

	public static void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.err.print("-> " + temp.value);
			temp = temp.next;
		}
		System.err.println("\n");
	}

	public static Node removeduplicates(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head.next;
		Node prev = head;
		int count = 0;
		Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
		while (curr != null) {
			int data = curr.value;
			if (map.contains(data)) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				map.put(count, data);
				count++;
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
}
