package strings;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {

	public static void main(String[] args) {
		String str = "abzddab";
		// char c = firstRepeated(str);
		// System.err.println("First repeated char is " + c);
		// firstRepeated(str);

		// firstNonRepeated(str);
	}

	public static void firstRepeated(String str) {
		char c[] = str.toCharArray();
		int len = str.length();
		Set<Character> set = new HashSet<Character>();
		int index = -1;
		for (int i = len - 1; i >= 0; i--) {
			if (set.contains(c[i])) {
				index = i;
			} else {
				set.add(c[i]);
			}
		}
		if (index == -1) {
			System.err.println("No repeated char found");
		} else {
		System.err.println(c[index]);
		}
	}


	public static void firstNonRepeated(String str) {
		int[] count = new int[256];
		char[] c = str.toCharArray();
		int len = str.length();
		int i = 0;
		for (i = 0; i < 256; ++i) {
			count[i] = 0;
		}
		for (i = 0; i < len; ++i) {
			count[c[i]]++;
		}
		for (i = 0; i < len; ++i) {
			if (count[c[i]] == 1) {
				System.err.println("First Non repeated char is " + c[i]);
				break;
			}

		}
	}
}
