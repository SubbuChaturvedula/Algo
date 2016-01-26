package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedParentheses {
	public static void main(String args[]) {
		// Scanner sc = new Scanner(System.in);
		// int length = Integer.parseInt(sc.nextLine());
		String inputArr[] = { "{[()]}", "{[(])}", "{{[[(())]]}}" };
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

	static String checkBraces(String value) {
		Stack<Character> specialCharStack = new Stack<Character>();
		String response = "NO";
		char tempChar;
		Character[] openingBraces = { '[', '(', '{' };
		Character[] closingBraces = { ']', ')', '}' };
		List<Character> openingBracesList = Arrays.asList(openingBraces);
		List<Character> closingBracesList = Arrays.asList(closingBraces);
		if (value == null) {
			return response;
		} else if (value.length() == 0) {
			response = "YES";
		} else {

			for (int i = 0; i < value.length(); i++) {
				tempChar = value.charAt(i);

				if (openingBracesList.contains(tempChar)) {
					specialCharStack.push(tempChar);
				} else if (closingBracesList.contains(tempChar)) {
					if (!specialCharStack.isEmpty()) {
						if (tempChar == ')' && '(' != specialCharStack.pop()) {
							return response;
						} else if (tempChar == '}' && '{' != specialCharStack.pop()) {
							return response;
						} else if (tempChar == ']' && '[' != specialCharStack.pop()) {
							return response;
						}
					} else {
						return response;
					}
				} else {
					return response;
				}
			}

		}
		if (specialCharStack.isEmpty()) {
			response = "YES";
			return response;
		} else {
			return response;
		}
	}
}
