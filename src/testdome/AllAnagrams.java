package testdome;

import java.util.Collection;
import java.util.HashSet;

public class AllAnagrams {

	public static void main(String... args) {
		String inputString = "abc";
		System.err.println(getAllAnagrams(inputString));

	}

	/**
	 * method returns permutations of string.
	 */

	public static Collection<String> getAllAnagrams(String string) {
		Collection<String> set = new HashSet<String>();
		Collection<String> set2;
		String stringWithoutFirstChar;
		char firstChar;

		if (string.length() == 0) {
			set.add("");
			return set;
		}
		firstChar = string.charAt(0);
		stringWithoutFirstChar = string.substring(1);
		set2 = getAllAnagrams(stringWithoutFirstChar);
		for (String s : set2) {
			for (int k = 0; k <= s.length(); k++) {
				set.add(insertCharacter(s, firstChar, k));
			}
		}
		return set;
	}

	public static String insertCharacter(String s, char ch, int i) {
		String begin = s.substring(0, i);
		String end = s.substring(i);
		return begin + ch + end;
	}

}
/*
 * OUTPUT
 * 
 * Permutations of inputString(XYZ) are: [XYZ, XZY, YZX, ZYX, ZXY, YXZ]
 * 
 */