package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public boolean findUsingDP(String s, Set<String> dict, Set<String> memory, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {

			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word already being solved
				if (dict.contains(word)) {
					if (findUsingDP(s.substring(index + 1), dict, memory, answer + word + " ")) {
						return true;
					} else {
						System.out.println("backtrack");
						index++;
					}
					memory.add(s);// memoization for future;
				} else {
					index++;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("sumit");
		hs.add("jain");
		hs.add("the");
		hs.add("problem");
		String s = "thisissumitjainthisisproblem";

		WordBreak ws = new WordBreak();

		// create another HashSet so store the sub problems result
		Set<String> memoization = new HashSet<String>();
		ws.findUsingDP(s, hs, memoization, "");

	}

}
