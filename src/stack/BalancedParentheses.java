package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedParentheses {
	public static void main(String args[]) {
		// Scanner sc = new Scanner(System.in);
		// int length = Integer.parseInt(sc.nextLine());
		String inputArr[] = { "{[()]}", "{[(])}", "{{[[(())]]}}" };//
		// for (int i = 0; i < length; i++) {
		// String stupid = sc.nextLine();
		// System.out.println(checkBraces(stupid));
		// }
		for (int i = 0; i < inputArr.length; i++) {
			String stupid = inputArr[i];
			System.out.println(checkBraces(stupid));
		}
		// sc.close();
	}

	public static String checkBraces(String str) {
		String result = "NO";
		List<Character> openBraceList = Arrays.asList(new Character[] { '(', '[', '{' });
		List<Character> closeBraceList = Arrays.asList(new Character[] { ')', ']', '}' });
		Stack<Character> s = new Stack<Character>();
		if (str == null) {
			return result;
		} else if (str.length() == 0) {
			result = "YES";
		} else {
			for (int i = 0; i < str.length(); i++) {
				char temp = str.charAt(i);
				if (openBraceList.contains(temp)) {
					s.push(temp);
				} else if (closeBraceList.contains(temp)) {
					if (!s.isEmpty()) {
						if (temp == ')' && '(' != s.pop()) {
							return result;
						} else if (temp == ']' && '[' != s.pop()) {
							return result;
						} else if (temp == '}' && '{' != s.pop()) {
							return result;
						}
					} else {
						return result;
					}
				} else {
					return result;
				}
			}
		}
		if (s.isEmpty()) {
			result = "YES";
			return result;
		} else {
			return result;
		}
	}
}
