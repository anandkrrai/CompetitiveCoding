package arraysAndstrings;

import java.util.*;

public class MaxEqualFreq {
	public static int maxEqualFreq(int[] nums) {
		HashMap<Integer, Integer> elementFreq = new HashMap<>();
		HashMap<Integer, Integer> freqCount = new HashMap<>();
		int rv = 0;

		for (int i = 0; i < nums.length; ++i) {
			int val = nums[i];
			elementFreq.put(val, elementFreq.getOrDefault(val, 0) + 1);
			int newFreq = elementFreq.get(val);

			freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
			freqCount.put(newFreq - 1, freqCount.getOrDefault(newFreq - 1, 0) - 1);

			if (freqCount.get(newFreq - 1) <= 0)
				freqCount.remove(newFreq - 1);

			if (freqCount.size() == 1 && (elementFreq.size() == 1 || elementFreq.size() == i + 1))
				rv = i + 1;
			else if (freqCount.size() == 2) {
				ArrayList<Integer> lis = new ArrayList<Integer>(freqCount.keySet());
				Collections.sort(lis);
				if (freqCount.get(lis.get(0)) == 1 && lis.get(0) == 1) {
					rv = i + 1;
				} else if (lis.get(1) - lis.get(0) == 1 && freqCount.get(lis.get(1)) == 1) {
					rv = i + 1;
				}

			}
			System.out.println(rv);
		}
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 42, 21, 45, 27, 78, 39, 78,
				24, 47, 60, 22, 33, 45, 18, 56, 91, 93, 66, 79, 65, 43, 7, 57, 63, 74, 25, 11, 14, 100, 95, 19, 3, 22,
				18, 94, 52, 91, 33, 95, 16, 93, 63, 65, 8, 88, 51, 47, 7, 51, 77, 36, 48, 89, 72, 81, 75, 13, 69, 9, 31,
				16, 38, 34, 76, 7, 82, 10, 90, 64, 28, 22, 99, 40, 88, 27, 94, 85, 43, 75, 95, 86, 82, 46, 9, 74, 67,
				51, 93, 97, 35, 2, 49 };
		System.out.println(maxEqualFreq(arr));
	}

}
