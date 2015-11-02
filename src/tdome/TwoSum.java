package tdome;

import java.util.HashMap;

///O(n) time complexity and O(n) space
public class TwoSum {

	public static int[] findTwoSum(int[] list, int sum) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.length; i++) {
			System.err.print(list[i]);
			if (hashMap.containsKey(sum - list[i])) {
				return new int[] { hashMap.get(sum - list[i]), i };
			}
			hashMap.put(list[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 8);
		// System.out.println(indices[0] + " " + indices[1]);

	}
}