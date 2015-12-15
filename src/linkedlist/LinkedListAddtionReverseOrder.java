package linkedlist;

public class LinkedListAddtionReverseOrder {
	// Two numbers represented by a linked list where each node contains single digit.
	// The digits are stored in REVERSE order, means head is pointing to the
	// first digit of the number.

	public static void main(String[] args) {
		Node h1 = new Node(5);
		h1.next = new Node(9);
		h1.next.next = new Node(5);
		h1.next.next.next = new Node(7);
		System.out.println("First Number in Linked List :");
		print(h1);
		System.out.println();
		Node h2 = new Node(5);
		h2.next = new Node(9);
		System.out.println("Second Number in Linked List :");
		print(h2);
		System.out.println();
		Node sum = add(h1, h2);
		System.out.println("Sum of two numbers reverse order :");
		print(sum);
		System.out.println();
		System.out.println("Actual Result in Forward Order :");
		printReverse(sum);
	}

	public static Node add(Node h1, Node h2) {
		int carry = 0;
		Node newHead = null;
		Node curr = null;
		while (h1 != null && h2 != null) {
			int a = h1.value;
			int b = h2.value;
			int total = a + b + carry;
			if (total >= 10) {
				total = total - 10;
				carry = 1;
			}
			if (newHead == null) {
				newHead = new Node(total);
				curr = newHead;
			} else {
				Node n = new Node(total);
				curr.next = n;
				curr = curr.next;
			}
			h1 = h1.next;
			h2 = h2.next;
		}
		while (h1 != null) {
			int x = h1.value + carry;
			Node n = new Node(x);
			curr.next = n;
			curr = curr.next;
			h1 = h1.next;
			carry = 0;
		}
		while (h2 != null) {
			int x = h2.value + carry;
			Node n = new Node(x);
			curr.next = n;
			curr = curr.next;
			h2 = h2.next;
			carry = 0;
		}
		if (carry > 0) {
			Node n = new Node(1);
			curr.next = n;
			curr = curr.next;
		}
		return newHead;
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}

	public static void printReverse(Node head) {
		if (head == null) {
			return;
		}
		printReverse(head.next);
		System.out.print(head.value + " ");
	}

}
