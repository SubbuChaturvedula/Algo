package strings;

public class AnagramExistenceStringArray {

	static final String[] INPUT_ARRAY = { "bag", "bat", "tab" };

	// static final String[] INPUT_ARRAY = { "gab", "bat", "laf" };

	public static void main(String[] args) {
		System.out.println(verifyAnagramExistence(INPUT_ARRAY));
	}

	public static boolean verifyAnagramExistence(String[] str) {
		boolean isAnagramExist = false;
		int[] ascii = new int[str.length];
		int index = 0;
		for (String s : str) {
			int value = getAsciiValue(s);
			if (!isAlreadyExist(ascii, value))
				ascii[index++] = value;
			else {
				isAnagramExist = true;
				break;
			}
		}
		return isAnagramExist;
	}

	public static int getAsciiValue(String s) {
		int sum = 0;
		for (char ch : s.toCharArray()) {
			sum += ch;// String.valueOf(ch).codePointAt(0);
		}
		return sum;
	}

	public static boolean isAlreadyExist(int[] ascii, int value) {
		for (int number : ascii) {
			if (number == value)
				return true;
		}
		return false;
	}

	// 1. Assign a prime number to each letter (a = 2, b = 3, c = 5, ...)
	// 2. For each word compute the hash as the product of the prime numbers
	// associated with each letter
	// 3. Store the hash in a set - if it's already there, you have anagrams
	//
	// Time: O(n), where n is the number of letters, Space: O(n), where n is the
	// number of words.
}
