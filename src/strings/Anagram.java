package strings;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static boolean anagram(String s, String t) {
		// Strings of unequal lengths can't be anagrams
		if (s.length() != t.length()) {
			return false;
		}

		// They're anagrams if both produce the same 'frequency map'
		Map<Character, Integer> map = frequencyMap(s, t);
		for (int i : map.values()) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	// For example, returns `{b=3, c=1, a=2}` for the string "aabcbb"
	public static Map<Character, Integer> frequencyMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toLowerCase().toCharArray()) {
			Integer frequency = map.get(c);
			map.put(c, frequency == null ? 1 : frequency + 1);
		}
		return map;
	}

	public static Map<Character, Integer> frequencyMap(String str1, String str2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str1.toLowerCase().toCharArray()) {
			Integer frequency = map.get(c);
			map.put(c, frequency == null ? 1 : frequency + 1);
		}
		for (char c : str2.toLowerCase().toCharArray()) {
			Integer frequency = map.get(c);
			map.put(c, frequency == null ? 1 : frequency - 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String s = "GoD";
		String t = "Dog";
		System.out.println(anagram(s, t));

	}
}
