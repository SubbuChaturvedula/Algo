package strings;

public class Pangram {
	// pangrams are sentences constructed by using every letter of the alphabet
	// at least once.

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// String inputString = in.nextLine();
		String inputString = "We promptly judged antique ivory buckles for the next prize";
		System.out.println(isPangram(inputString));
		// in.close();
	}

	public static String isPangram(String input) {
		boolean[] charBM = new boolean[26];
		String inputLower = input.toLowerCase();
		char aCharNum = 'a';
		for (int i = 0; i < inputLower.length(); i++) {
			if (inputLower.charAt(i) != ' ') {
				char c = inputLower.charAt(i);
				charBM[c % aCharNum] = true;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (charBM[i] == false) {
				return "not pangram";
			}
		}
		return "pangram ";
	}

	// easy approach
	public static boolean isPangramString(String s) {
		if (s.length() < 26)
			return false;
		else {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (s.indexOf(ch) < 0) {
					return false;
				}
			}
		}

		return true;
	}
}
