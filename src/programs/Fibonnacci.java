package programs;

public class Fibonnacci {

	static int prev = 0, next = 1;
	static int sum = 0;

	public static void main(String[] args) {
		FibonnacciIterative();
	}

	public static void FibonnacciIterative() {
		System.out.println("Printing Fibonacci series:");
		// first two number of series
		int prev = 0, next = 1;
		// printing first two elements
		System.out.print(prev + " " + next);
		// number of elements to be printed
		int numberOfElements = 10;
		int sum = 0;
		for (int i = 2; i < numberOfElements; i++) {
			sum = prev + next;
			System.out.print(" " + sum);
			prev = next;
			next = sum;
		}
	}

	public static void printFibonacciSeriers(int numberOfElements) {
		if (numberOfElements == 0)
			return;
		else {
			sum = prev + next;
			System.out.print(" " + sum);
			// prepare for next 2 terms
			prev = next;
			next = sum;
			printFibonacciSeriers(numberOfElements - 1);
		}
	}
}
