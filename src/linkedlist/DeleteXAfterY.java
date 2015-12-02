package linkedlist;

public class DeleteXAfterY {

	public static Node head;
	public static int length;
	public static void main(String[] args) {
		addNodeAtEnd(10);
		addNodeAtEnd(20);
		addNodeAtEnd(30);
		addNodeAtEnd(40);
		addNodeAtEnd(50);
		addNodeAtEnd(60);
		addNodeAtEnd(70);
		addNodeAtEnd(80);
		addNodeAtEnd(90);
		display();
		deleteXAfterY(3, 5);
		System.err.println();
		display();
	}

	public static void deleteXAfterY(int x, int y) {
		length = getLength(head);
		if (y >= length) {
			System.out.println("\nINVALID NUMBER");
			return;
		}
		Node temp1 = head;

		while (y > 1) { // since we need to one node prior before we start deleting
			temp1 = temp1.next;
			y--;
		}
		System.out.println("\n" + temp1.value);
		Node temp2 = temp1;

		x = x + 1;// since we need the next node,
		while (x > 0 && temp1 != null) {
			temp1 = temp1.next;
			x--;
		}
		System.out.println("\n" + temp1.value);
		System.out.println("\n" + temp2.value);
		temp2.next = temp1;
	}

	public static void display() {
		Node temp = head;
		while (temp != null) {
			System.err.print("->" + temp.value);
			temp = temp.next;
		}
	}

	public static int getLength(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static void addNodeAtEnd(int data) {
		Node n = new Node(data);
		if (head == null) {
			n.next = head;
			head = n;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
	}
}
