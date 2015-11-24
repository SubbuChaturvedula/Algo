package strings;


public class Urlify {

	// Replace all spaces in a String with %20
	public static void main(String[] args) {
		String str = "Cracking the Coding interview.";
		replaceSpaces(str.toCharArray(), str.length());
	}

	public static void replaceSpaces(char str[], int length) {
		// get the space count
		int spaceCount = 0;
		int newLength = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + 2 * spaceCount;
		// take a new array
		char[] newStr = new char[newLength];
		// insert from the end
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newStr[newLength - 1] = '0';
				newStr[newLength - 2] = '2';
				newStr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				newStr[newLength - 1] = str[i];
				newLength--;
			}
		}
		System.err.println(String.valueOf(newStr));
	}

}
