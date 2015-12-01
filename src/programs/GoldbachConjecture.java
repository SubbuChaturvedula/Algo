package programs;

//Every even integer greater than 2 can be represented as the sum of two primes numbers.

public class GoldbachConjecture {

	public GoldbachConjecture(int n) {
		if (n % 2 != 0) {
			System.err.println(" Given Number is not even ");
			return;
		}
		if (n <= 2) {
			System.err.println(" Given Number less than 2 ");
			return;
		}
		for (int i = 3; i < n / 2; i++) {
			if (isPrime(i) && isPrime(n - i)) {
				System.err.println(i + " " + (n - i));
			}
		}
	}

	public boolean isPrime(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 100;
		new GoldbachConjecture(n);
	}

}
