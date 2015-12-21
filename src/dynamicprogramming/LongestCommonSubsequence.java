package dynamicprogramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String A = "ACBDEA";
		String B = "ABCDA";
		System.out.println("LCS through Dynamic Programming :" + find(A.toCharArray(), B.toCharArray()));
		System.out.println("LCS through Recursion :" + LCS(A,B));
	}

	public static int LCS(String A, String B) {
		if (A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int lenA = A.length();
		int lenB = B.length();
		// check if last characters are same
		if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
			// Add 1 to the result and remove the last character from both
			// the strings and make recursive call to the modified strings.
			return 1 + LCS(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
		} else {
			// Remove the last character of String 1 and make a recursive
			// call and remove the last character from String 2 and make a
			// recursive and then return the max from returns of both recursive
			// calls
			return Math.max(LCS(A.substring(0, lenA - 1), B.substring(0, lenB)),
					LCS(A.substring(0, lenA), B.substring(0, lenB - 1)));
		}
	}

	public static int find(char[] A, char[] B) {
		int[][] LCS = new int[A.length + 1][B.length + 1];
		String[][] solution = new String[A.length + 1][B.length + 1];
		// if A is null then LCS of A, B =0
		for (int i = 0; i <= B.length; i++) {
			LCS[0][i] = 0;
			solution[0][i] = "0";
		}

		// if B is null then LCS of A, B =0
		for (int i = 0; i <= A.length; i++) {
			LCS[i][0] = 0;
			solution[i][0] = "0";
		}

		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
					solution[i][j] = "diagonal";
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
					if (LCS[i][j] == LCS[i - 1][j]) {
						solution[i][j] = "top";
					} else {
						solution[i][j] = "left";
					}
				}
			}
		}
		// below code is to just print the result
		String x = solution[A.length][B.length];
		String answer = "";
		int a = A.length;
		int b = B.length;
		while (x != "0") {
			if (solution[a][b] == "diagonal") {
				answer = A[a - 1] + answer;
				a--;
				b--;
			} else if (solution[a][b] == "left") {
				b--;
			} else if (solution[a][b] == "top") {
				a--;
			}
			x = solution[a][b];
		}
		System.out.println(answer);

		for (int i = 0; i <= A.length; i++) {
			for (int j = 0; j <= B.length; j++) {
				System.out.print(" " + LCS[i][j]);
			}
			System.out.println();
		}
		return LCS[A.length][B.length];
	}
}
