package arrays;
//Given an Inte­ger array. Array con­tains dupli­cates of all the num­bers in array except one num­ber . Find that number.

public class MissingDuplicate {

	public static void main(String[] args) {
		int[] A = { 2, 1, 3, 5, 5, 3, 2, 1, 6, 7, 7, 8, 8 };
		System.err.println(findMissingDuplicate(A));
	}

	public static int findMissingDuplicate(int a[]) {
		int miss = a[0];
		for (int i = 1; i < a.length; i++) {
			miss = miss ^ a[i];
		}
		return miss;
	}

}
