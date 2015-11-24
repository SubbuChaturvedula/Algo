package priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };
		int k = 4;
		System.err.println(findKthSmallest(a, k));
	}

	public static int findKthSmallest(int a[], int k) {
		int x = -1;
		Queue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < a.length; i++) {
			q.offer(a[i]);
		}

		while (k > 0) {
			x = q.poll();
			k--;
		}
		return x;
	}
}
