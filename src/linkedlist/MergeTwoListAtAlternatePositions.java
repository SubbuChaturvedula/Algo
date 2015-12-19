package linkedlist;

public class MergeTwoListAtAlternatePositions {
	public static void main(String[] args) {
		Node a = new Node(5);
		a.next = new Node(10);
		a.next.next = new Node(15);
		a.next.next.next = new Node(20);
		a.next.next.next.next = new Node(25);
		print(a);
		System.out.println();
		Node b = new Node(3);
		b.next = new Node(6);
		b.next.next = new Node(9);
		b.next.next.next = new Node(12);
		b.next.next.next.next = new Node(15);
		b.next.next.next.next.next = new Node(18);
		print(b);
		System.out.println();
		alternateMerge(a, b);
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void alternateMerge(Node a, Node b) {
		Node temp = a;
		while (a != null && b != null) {
			Node a1 = a.next;
			Node b1 = b.next;
			a.next = b;
			b.next = a1;
			a = a1;
			b = b1;
		}
		System.out.println("\nAlternate Mergred List");
		print(temp);
		if (b != null) {
		System.out.println("\nRemaining Second List");
		print(b);
		}
	}
}

