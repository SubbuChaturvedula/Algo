package linkedlist;

public class ReverseLinkedList {

	private static Node head;

	public void insert(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.err.print(temp.value + " ");
			temp = temp.next;
		}
	}

	public void reverse() {
		Node previousNode = null;
		Node currentNode = head, nextNode = head;
		while (nextNode != null) {
			nextNode = nextNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = previousNode;
	}

	public Node reverseRecursion(Node temp) {
		if (temp == null) {
			return null;
		}
		if (temp.next == null) {
			head = temp;
			return null;
		}
		reverseRecursion(temp.next);
		temp.next.next = temp;
		temp.next = null;
		return head;
	}
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		// Node fifth = new Node(5);

		list.insert(head);
		list.insert(second);
		list.insert(third);
		list.insert(fourth);
		// list.insert(fifth);
		System.err.println("Elements before reversing :");
		list.print();
		System.err.println();
		list.reverseRecursion(head);
		System.err.println("Elements After reversing :");
		list.print();
	}
}
