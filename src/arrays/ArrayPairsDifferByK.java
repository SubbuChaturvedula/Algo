package arrays;

import java.util.HashSet;
import java.util.Set;

public class ArrayPairsDifferByK {

	/*
	 * O(n) Given an array of positive,unique, increasingly SORTED numbers A, e.g.A=[1,2,3,5,6,8,9,11,12,13]. Given a
	 * positive value K,e.g.K=3. Output all pairs in A that differ exactly by K.
	 */

	public static void computeDifference(int a[], int k) {
		for (int i = 0, j = 1; j < a.length && i < j;) {
			if (a[j] - a[i] == k) {
				System.err.println(a[i] + " " + a[j]);
				j++;
			}
			if (a[j] - a[i] > k) {
				i++;
			}
			if (a[j] - a[i] < k) {
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 5, 6, 8, 9, 11, 12, 13 };
		int k = 3;
		computeDifferenceBySet(a, k);
	}

	public static void computeDifferenceBySet(int a[], int k) {
		Set<Integer> set = new HashSet<>();
		set.add(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (set.contains(a[i] - k)) {
				System.out.println(a[i] - k + " , " + a[i]);
			}
			set.add(a[i]);
		}
	}
}
