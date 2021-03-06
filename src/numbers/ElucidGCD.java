package numbers;


public class ElucidGCD {

	public static void main(String[] args) {
		System.err.println(findGCD(156, 282));
	}

	public static int findGCD(int number1, int number2) {
		// base case
		if (number2 == 0) {
			return number1;
		}
		return findGCD(number2, number1 % number2);
	}
}
