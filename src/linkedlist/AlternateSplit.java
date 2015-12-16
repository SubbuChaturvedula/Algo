package linkedlist;

public class AlternateSplit {

	public static Node head = null;
	public static Node headA = null;
	public static Node headB = null;

	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		print(head);
		alternateSplit();
		System.out.println("\n After Alternate Splitting :");
		print(headA);
		print(headB);
	}

	public static void print(Node x) {
		System.out.println("");
		Node curr = x;
		while (curr != null) {
			System.out.print("->" + curr.value);
			curr = curr.next;
		}
	}

	public static void alternateSplit() {
		Node current = head;
		if (current == null || current.next == null) {
			return;
		}
		headA = current;
		headB = current.next;
		while (current != null && current.next != null) {
			Node temp = current.next;
			current.next = temp.next;// set the next node for first linked list

			// Now check if next node is available for second Linked List
			if (current.next != null && current.next.next != null) {
				temp.next = current.next.next;
			} else { // we have reached to the end
				temp.next = null;
				return;
			}
			current = current.next; // keep moving forward
		}
	}
}
