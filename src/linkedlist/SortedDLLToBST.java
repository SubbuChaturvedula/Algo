package linkedlist;
public class SortedDLLToBST {
	public static DLNode head = null;
	public static DLNode tail = null;
	public static int size = 0;

	public void insertFirst(int data) {
		DLNode n = new DLNode(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
		size++;
	}

	public DLNode dLLtoBST(int size) {
		if (size <= 0) {
			return null;
		}
		DLNode left = dLLtoBST(size / 2);
		DLNode root = head;
		root.prev = left;
		head = head.next;
		root.next = dLLtoBST(size - (size / 2) - 1);
		return root;
	}

	public void inOrder(DLNode root) {
		if (root != null) {
			inOrder(root.prev);
			System.out.print("  " + root.value);
			inOrder(root.next);
		}
	}

	public void printDLL(DLNode head) {
		DLNode curr = head;
		while (curr != null) {
			System.out.print("  " + curr.value);
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		SortedDLLToBST r = new SortedDLLToBST();
		r.insertFirst(9);
		r.insertFirst(8);
		r.insertFirst(7);
		r.insertFirst(6);
		r.insertFirst(5);
		r.insertFirst(4);
		r.insertFirst(3);
		r.insertFirst(2);
		r.insertFirst(1);
		DLNode h = head;
		System.out.println("DLL is : ");
		r.printDLL(h);
		DLNode x = r.dLLtoBST(size);
		System.out.println("Inorder traversal of contructed BST");
		r.inOrder(x);
	}
}
