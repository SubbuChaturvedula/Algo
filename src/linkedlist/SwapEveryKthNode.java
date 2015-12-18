package linkedlist;

public class SwapEveryKthNode {

	public static Node head = null;

	public static void main(String[] args) {
		insertFirst(10);
		insertFirst(9);
		insertFirst(8);
		insertFirst(7);
		insertFirst(6);
		insertFirst(5);
		insertFirst(4);
		insertFirst(3);
		insertFirst(2);
		insertFirst(1);
		System.out.println("Original Link List  : ");
		print(head);
		System.out.println("");
		System.out.println("=================================");
		System.out.println("After Swapping Every Second Node   : ");
		Node swappedHead = swapKth(head, 4);
		print(swappedHead);
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
	}

	public static void insertFirst(int value) {
		Node n = new Node(value);
		n.next = head;
		head = n;
	}

	public static Node swapKth(Node head, int k) {
		int x = k;
		Node ptrOne = head;
		Node ptrTwoPrev = head;
		Node ptrTwo = null;
		if (k < 2) {
			return head;
		}
		if (ptrOne != null) {
			ptrTwo = ptrOne.next;
		} else {
			return null;
		}
		while (x - 2 > 0) {
			if (ptrTwo != null) {
				ptrTwoPrev = ptrTwo;
				ptrTwo = ptrTwo.next;
				x--;
			} else {
				return head;
			}
		}
		Node newHead = ptrTwo.next;
		ptrTwoPrev.next = ptrOne;
		ptrTwo.next = ptrOne.next;
		ptrOne.next = swapKth(newHead, k);
		return ptrTwo;
	}
}
