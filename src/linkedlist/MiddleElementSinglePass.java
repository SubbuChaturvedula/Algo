package linkedlist;

public class MiddleElementSinglePass {
	private static Node head;
	public static void main(String[] args) {
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);

		insert(head);
		insert(two);
		insert(three);
		insert(four);
		insert(five);
		insert(six);
		insert(seven);
		insert(eight);


		System.out.println(" Elements of linkedlist are: ");
		print();
		Node middle = getMiddleElement(head);
		System.out.println();
		System.out.println("Middle Element in the linkedlist is : " + middle.value);

	}

	public static void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "-->");
			temp = temp.next;
		}
	}

	/**
	 * get middle element of linked list with two pointers in single pass
	 */
	public static Node getMiddleElement(Node head) {
		Node firstPointer = head;
		Node secondPointer = head;
		while (firstPointer != null && firstPointer.next != null) {
			firstPointer = firstPointer.next.next;
			secondPointer = secondPointer.next;
		}
		return secondPointer;
	}

	public static void insert(Node node) {
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

	public static int getSize() {
		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}
}
