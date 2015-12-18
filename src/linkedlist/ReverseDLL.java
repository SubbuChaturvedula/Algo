package linkedlist;

public class ReverseDLL {

	public static  DLNode head=null;
	
	public static void main(String[] args) {
		insertFirst(1);
		insertFirst(2);
		insertFirst(3);
		insertFirst(4);
		print(head);
		System.out.println();
		System.out.println("After Reversing Double Linked List");
		DLNode node = reverseDLL();
		print(node);
	}

	public static void print(DLNode head) {
		DLNode current = head;
		while (current != null) {
			System.out.print("->" + current.value);
			current = current.next;
		}
	}

	public static DLNode reverseDLL() {
		DLNode current = head;
		DLNode temp = null;
		while (current != null) {
			temp = current.prev; // swap the next and prev pointer
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		return temp.prev;
	}

	public static void insertFirst(int value) {
		DLNode n=new DLNode(value);
		if(head==null){
			head=n;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
	}
}

