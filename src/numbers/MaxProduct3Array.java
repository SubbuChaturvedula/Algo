package numbers;

public class MaxProduct3Array {
	public static void main(String[] args) {
		int arr[] = { -1, -5, -2, -6, 2, 5, 3, 1, 9 };
		System.out.println(getMaxProduct(arr));
	}

	public static int getMaxProduct(int array[]) {
		int max1 = Integer.MIN_VALUE;
		int max2 = max1;
		int max3 = max1;

		int min1 = Integer.MAX_VALUE;
		int min2 = min1;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max1) {
				max2 = max1;
				max1 = array[i];
			} else if (array[i] > max2) {
				max3 = max2;
				max2 = array[i];
			} else if (array[i] > max3) {
				max2 = array[i];
			}
			if (array[i] < min1) {
				min2 = min1;
				min1 = array[i];
			} else if (array[i] < min2) {
				min2 = array[i];
			}
		}
		System.out.println("max1 = " + max1 + " max2 = " + max2 + " max3 = " + max3);
		System.out.println("min1 = " + min1 + " min2 = " + min2);
		System.out.println();
		return max1 * max2 * max3 > max1 * min1 * min2 ? max1 * max2 * max3 : max1 * min1 * min2;
	}
}
