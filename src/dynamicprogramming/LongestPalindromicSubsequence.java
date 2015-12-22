package dynamicprogramming;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String strA = "abacba";
		int x = find(strA);
		System.out.println("Length of Longest Palindrome in '" + strA + "' is : " + x);
	}

	public static int find(String s) {
		char[] chars = s.toCharArray();
		int[][] LP = new int[chars.length][chars.length];
		String[][] solution = new String[chars.length][chars.length];
		for (int i = 0; i < chars.length; i++) {
			LP[i][i] = 1;
			solution[i][i] = "1";
		}
		for (int sublen = 2; sublen <= chars.length; sublen++) {
			for (int i = 0; i <= LP.length - sublen; i++) {
				int j = i + sublen - 1;
				if (chars[i] == chars[j] && sublen == 2) {
					LP[i][j] = 2;
					solution[i][j] = "diagonal";
				} else if (chars[i] == chars[j]) {
					LP[i][j] = LP[i + 1][j - 1] + 2;
					solution[i][j] = "top";
				} else {
					LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
					solution[i][j] = "left";
				}
			}
		}
		printMatrix(LP);
		return LP[0][LP.length - 1];
	}

	public static void printMatrix(int[][] LP) {
		for (int i = 0; i < LP.length; i++) {
			for (int j = 0; j < LP.length; j++) {
				System.out.print("  " + LP[i][j]);
			}
			System.out.println("");
		}
	}
}
