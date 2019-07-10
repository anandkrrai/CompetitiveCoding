package dp;

import java.util.*;

public class ArithmeticSlices2 {
	public static int numberOfArithmeticSlices(int[] A) {
		if (A.length <= 2)
			return 0;
		ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();

		for (int i = 0; i < A.length; ++i) {
			list.add(new HashMap<Integer, Integer>());
		}

		int rv = 0;
		for (int i = 1; i < A.length; ++i) {
			for (int j = 0; j < i; ++j) {
				int diff = A[i] - A[j];
				HashMap<Integer, Integer> map = list.get(j);
				int val = map.getOrDefault(diff, 0);
				rv += val;
				list.get(i).put(diff, list.get(i).getOrDefault(diff, 0) + val + 1);
			}
		}
		return rv;
	}
	

	public static void main(String[] args) {

//		int[] arr = { 2, -2, 4, 0, 6, 8, 10, -1, 3, 6 };
//		int[] arr = { 2, 4, 6, 8, 10 };
		int[] arr = { 2, 2, 3, 4 };
		System.out.println(numberOfArithmeticSlices(arr));
	}

}
