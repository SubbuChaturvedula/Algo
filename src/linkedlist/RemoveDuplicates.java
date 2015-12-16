package linkedlist;

import java.util.Hashtable;
//Time Complexity : O(n)
//Space Complexity : O(n)

//Follow Up: If suppose addition buffer is not allowed then we have option but to 
//check every node data against every other node data and if find duplicates, delete that node.
//Time Complexity : O(n^2)
public class RemoveDuplicates {
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(1);
		n.next.next = new Node(2);
		n.next.next.next = new Node(2);
		n.next.next.next.next = new Node(3);
		n.next.next.next.next.next = new Node(2);
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
		Node curr = head;
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
