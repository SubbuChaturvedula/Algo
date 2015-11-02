package testdome;

public class Frog {

	public static int numberOfWays(int n) {
		int pre = 0, curr = 1, sum = 0;
		for (int i = 0; i < n; i++) {
			sum = pre + curr;
			pre = curr;
			curr = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numberOfWays(3));
	}
}