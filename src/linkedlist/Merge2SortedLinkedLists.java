package linkedlist;

public class Merge2SortedLinkedLists {

	public static void main(String[] args) {
		Node list1 = new Node(5);
		list1.next = new Node(6);
		list1.next.next = new Node(8);
		System.out.println("First linked list:");
		print(list1);
		Node list2 = new Node(1);
		list2.next = new Node(3);
		list2.next.next = new Node(7);
		list2.next.next.next = new Node(9);
		System.out.println("Second Linked List:");
		print(list2);
		System.out.println("Combined Linked List :");
		Node mergedList = mergeIteratively(list1, list2);
		print(mergedList);
	}

	public static Node mergeRecursively(Node list1, Node list2) {
		Node result = null;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.value < list2.value) {
			result = list1;
			result.next = mergeRecursively(list1.next, list2);
		} else {
			result = list2;
			result.next = mergeRecursively(list1, list2.next);
		}
		return result;
	}

	public static Node mergeIteratively(Node list1, Node list2) {
		Node result = null;
		while (list1 != null && list2 != null) {
			if (list1.value < list2.value) {
				result = insertLast(result, list1.value);
				list1 = list1.next;
			} else {
				result = insertLast(result, list2.value);
				list2 = list2.next;
			}
		}
		while (list1 != null) {
			result = insertLast(result, list1.value);
			list1 = list1.next;
		}
		while (list2 != null) {
			result = insertLast(result, list2.value);
			list2 = list2.next;
		}
		return result;
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node insertFirst(Node result, int value) {
		Node node = new Node(value);
		node.next = result;
		result = node;
		return result;
	}

	public static Node insertLast(Node result, int value) {
		Node node = new Node(value);
		if (result == null) {
			return insertFirst(result, value);
		} else {
			Node temp = result;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			return result;
		}

	}
}
