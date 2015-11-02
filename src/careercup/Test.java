package careercup;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 9, 2, 1, 3 };
		int b[] = new int[a.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0, j = 1; j < a.length && i < j;) {
			if (a[i] < a[j]) {
				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]) + 1);
				} else {
					map.put(a[i], j);

				}
				j++;
			}
			if (a[i] > a[j]) {
				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]));
				} else {
					map.put(a[i], i);
				}

				i++;
			}

		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.err.println(entry.getKey() + "  " + entry.getValue());
		}

		for (int k : b) {
			System.err.print(k + " ");
		}

	}

}
