package backtracking;

public class StringPermutations {

	public static void main(String[] args) {
		String s = "abc";
		char[] arrCh = s.toCharArray();
		permutation(arrCh, 0, s.length());
	}

	public static void permutation(char[] arrA, int left, int size) {
		if (left == size) {
			for (int i = 0; i < arrA.length; i++) {
				System.out.print(arrA[i]);
			}
			System.out.print(" ");
		} else {
			for (int x = left; x < size; x++) {
				swap(arrA, left, x);
				permutation(arrA, left + 1, size);
				swap(arrA, left, x);
			}
		}
	}

	public static void swap(char[] arrA, int i, int j) {
		char temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;
	}

}
