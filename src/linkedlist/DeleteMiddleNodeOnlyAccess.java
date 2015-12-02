package linkedlist;

public class DeleteMiddleNodeOnlyAccess {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		Node mid = new Node(7);
		n.next.next.next.next = mid;
		n.next.next.next.next.next = new Node(10);
		Node last = new Node(4);
		n.next.next.next.next.next.next = last;
		display(n);
		System.err.println();
		deleteOnlyAccessNode(mid);
		display(n);
	}

	public static void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.err.print("-> " + temp.value);
			temp = temp.next;
		}
	}

	public static void deleteOnlyAccessNode(Node mid) {
		if (mid.next == null) {
			return; // we cant delete the node if it is the last node in the
					// linked list
		}
		Node temp = mid;
		temp.value = temp.next.value;
		temp.next = temp.next.next;
	}

}
