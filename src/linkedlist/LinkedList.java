package linkedlist;

/**
 
 *
 */
/**
 * @author subbu
 *
 */
public class LinkedList {

	private Node head;

	public void insertFirst(Node node) {
		node.next = head;
		head = node;
	}

	public Node deleteFirst(Node head) {
		Node temp = head;
		temp = temp.next;
		return temp;
	}

	/**
	 * Insert node in linked list
	 */
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
		System.err.println();
	}

	/**
	 * get middle element of linked list with two pointers in single pass
	 */
	public Node getMiddleElement(Node head) {
		Node fastPointer = head;
		Node slowPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		return slowPointer;
	}

	/**
	 * this will get middle element using length of linked list
	 */
	public Node getMiddleElementUsingLength(Node head) {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		temp = head;
		for (int i = 1; i <= length / 2; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * this will give nth node from the end O(n) O(1)
	 */
	public Node getNthNodeFromEnd(Node head, int n) {
		Node fastPointer = head;
		Node slowPointer = head;
		for (int i = 0; i < n; i++) {
			if (fastPointer != null) {
				fastPointer = fastPointer.next;
			}
		}
		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}
		return slowPointer;
	}

	/**
	 * Detect a loop in linked list O(n) O(1)
	 */
	public boolean isLoopExists(Node head) {

		Node fastPointer = head;
		Node slowPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer) {
				System.err.println(" LOOP EXISTS");
				return true;
			}
		}
		return false;
	}

	/**
	 * return START NODE OF THE LOOP & Prints length of the loop
	 */
	public Node startNodeOfLoop(Node head) {
		boolean loopExists = false;
		Node fastPointer = head;
		Node slowPointer = head;
		int lengthOfLoop = 0;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer) {
				System.err.println(" LOOP EXISTS");
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			slowPointer = head;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
				lengthOfLoop++;
			}
			System.err.println("Length of Loop is " + lengthOfLoop);
			return slowPointer;
		}
		return null;
	}

	public void printNthElement(Node head, int n) {
		Node temp = head;
		int length = 0;
		while (temp.next != null) {
			if (length == n) {
				System.out.println("Element at " + n + "th position is " + temp.value);
			}
			length++;
			temp = temp.next;

		}
		if (temp.next == null && length == n) {
			System.out.println("Element at " + n + "th position is " + temp.value);
		}

	}

	public void printFromEnd(Node node) {
		if (node == null)
			return;
		printFromEnd(node.next);
		System.err.println(node.value);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head = new Node(5);
		Node second = new Node(6);
		Node third = new Node(7);
		Node fourth = new Node(1);
		Node fifth = new Node(2);

		// list.insert(head);
		// list.insert(second);
		// list.insert(third);
		// list.insert(fourth);
		// list.insert(fifth);

		// list.insert(third);// looping 2 to 7

		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);

		list.insert(root);
		list.insert(two);
		list.insert(three);
		list.insert(four);
		list.insert(five);
		list.insert(six);
		list.insert(seven);
		list.insert(eight);

		// 8 t0 3

		list.insert(three);

		// boolean loopExists = list.isLoopExists(head);
		Node node = list.startNodeOfLoop(root);
		System.err.println(node.value);
		// Node middle = list.getMiddleElement(head);
		// Node middle = list.getMiddleElementUsingLength(head);
		// System.err.println();
		// System.err.println("Middle Element of linkedlist is " + middle.value);

		// Node nthElementFromEnd = list.getNthNodeFromEnd(head, 2);
		// System.err.println("nthElementFromEnd of linkedlist is " + nthElementFromEnd.value);

		// list.printNthElement(head, 4);
		// list.printFromEnd(head);

	}

}
