package arrays;


public class RunLengthEncoding {

	public static void main(String[] args) {
		String s1 = "ssssuuuummmmmmiiiittttttttttttt";
		System.err.println(compress(s1));
	}

	public static String compress(String input) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char previous = input.charAt(0);
		for (int i = 1; i < input.length(); i++) {
			char current = input.charAt(i);
			if (current == previous) {
				count++;
			} else {
				sb.append(previous);
				sb.append(count);
				previous = current;
				count = 1;
			}
		}
		sb.append(previous);
		sb.append(count);
		if (input.length() < sb.length()) {
			return input;
		} else {
			return sb.toString();
		}
	}

}
