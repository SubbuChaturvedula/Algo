package linkedlist;

public class InsertInSortedLinkedList extends LinkedList {

	public static void main(String[] args) {
		InsertInSortedLinkedList list = new InsertInSortedLinkedList();
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(4);
		Node fourth = new Node(5);
		Node fifth = new Node(6);

		Node three = new Node(3);
		list.insert(head);
		list.insert(second);
		list.insert(third);
		list.insert(fourth);
		list.insert(fifth);
		System.err.println("Before Inserting :");
		list.printFromStart(head);
		System.err.println("\nAfter Inserting Node 3:");
		list.insertInSorted(head, three);
		list.printFromStart(head);
	}

	public void printFromStart(Node node) {
		Node temp = node;
		while (temp != null) {
			System.err.print(temp.value + " ");
			temp = temp.next;
		}
	}

	public Node insertInSorted(Node head, Node nodeToInsert) {
		Node current = head;
		Node previous = head;
		while (current != null && nodeToInsert.value > current.value) {
			previous = current;
			current = current.next;
		}
		nodeToInsert.next = current;
		previous.next = nodeToInsert;
		return head;
	}

}
