package linkedlist;

public class LinkedListAddtionForwardOrder {

	public static int carry = 0;
	public static Node head = null;

	public static void main(String[] args) {
		Node h1 = new Node(1);
		h1.next = new Node(0);
		h1.next.next = new Node(0);
		h1.next.next.next = new Node(7);

		Node h2 = new Node(9);
		h2.next = new Node(3);

		Node x = add(h1, h2);
		System.out.println(" First Number is 1 0 0 7 : ");
		System.out.println(" Second Number is    9 3 : ");
		System.out.println("=============================");
		print(x);

	}

	public static Node add(Node h1, Node h2) {
		int x = getSize(h1);
		int y = getSize(h2);
		int diff = Math.abs(x - y);
		if (x > y) {
			while (diff > 0) {
				Node n = new Node(0);
				n.next = h2;
				h2 = n;
				diff--;
			}
		}
		if (y > x) {
			while (diff > 0) {
				Node n = new Node(0);
				n.next = h1;
				h1 = n;
				diff--;
			}
		}
		return addBackRecursion(h1, h2);
	}

	public static Node addBackRecursion(Node h1, Node h2) {
		if (h1 == null && h2 == null) {
			return null;
		}
		addBackRecursion(h1.next, h2.next);
		int total = h1.value + h2.value + carry;
		carry = 0;
		if (total >= 10) {
			total = total - 10;
			carry = 1;
		}
		Node n = new Node(total);
		if (head == null) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
		return head;
	}

	public static int getSize(Node head) {
		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}

}
