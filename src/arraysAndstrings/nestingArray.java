package arraysAndstrings;

import java.util.HashSet;

public class nestingArray {

	public static int maxLen(int[] arr) {
		int max = -1;

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; ++i) {
			if (set.contains(i))
				continue;

			int in = i;
			int local = 0;
			while (!set.contains(in)) {
				set.add(in);
				++local;
				in = arr[in];
			}
			max = Math.max(local, max);
		}

		return max;
	}

	public static void main(String[] args) {
//		int[] arr = { 5, 4, 0, 3, 1, 6, 2 };
		int[] arr = { 0, 1, 2 };
		System.out.println(maxLen(arr));
	}

}
