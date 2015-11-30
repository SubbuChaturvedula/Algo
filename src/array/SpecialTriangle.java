package array;

import java.util.Arrays;

//Given an array of integers such that first level will print all the 
//elements in the array and from then at each level number of elements 
//will be one less than the previous level and elements at the level 
//will be the Sum of consecutive elements in the previous level.
public class SpecialTriangle {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		constructTriangle(a);
	}

	public static void constructTriangle(int a[]) {
		if (a.length >= 1) {
			int temp[] = new int[a.length - 1];
			for (int i = 0; i < a.length - 1; i++) {
				int x = a[i] + a[i + 1];
				temp[i] = x;
			}
			constructTriangle(temp);
			System.err.println(Arrays.toString(a));
		}
	}

}
