package linkedlist;

public class MergeSortLL {

	public static void main(String[] args) {
		Node a = new Node(9);
		a.next = new Node(3);
		a.next.next = new Node(4);
		a.next.next.next = new Node(2);
		a.next.next.next.next = new Node(5);
		a.next.next.next.next.next = new Node(1);
		print(a);
		System.out.println();
		System.out.println("After Merge Sort:");
		Node sorted = mergeSort(a);
		print(sorted);
	}

	public static Node mergeSort(Node head) {
		Node oldHead = head;
		int mid = getLength(head) / 2;
		if (head.next == null) {
			return head;
		}
		while (mid - 1 > 0) {
			oldHead = oldHead.next;
			mid--;
		}
		Node newHead = oldHead.next;
		oldHead.next = null;
		// oldHead = head;
		Node t1 = mergeSort(oldHead);
		Node t2 = mergeSort(newHead);
		return merge(t1, t2);
	}

	public static Node merge(Node list1, Node list2) {
		Node result = null;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.value < list2.value) {
			result = list1;
			result.next = merge(list1.next, list2);
		} else {
			result = list2;
			result.next = merge(list1, list2.next);
		}
		return result;
	}

	public static int getLength(Node head) {
		Node temp = head;
		int length = 0;
		while (temp != null) {
			temp = temp.next;
		}
		return length;
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println();
	}
}
