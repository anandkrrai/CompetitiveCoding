package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class dfghjk {

	public static void main(String[] args) {
//		LinkedList<Integer> list = new LinkedList<Integer>();

		int[] arr = { 3,2, 3 };
		System.out.println(majorityElement(arr));

	}

	private static HashMap<Integer, Integer> countNums(int[] nums) {
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!counts.containsKey(num)) {
				counts.put(num, 1);
			} else {
				counts.put(num, counts.get(num) + 1);
			}
		}
		return counts;
	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> counts = countNums(nums);

		ArrayList<Integer> list = new ArrayList<Integer>(counts.keySet());
		int key = list.get(0), max = counts.get(key);

		for (int x : list) {
			if (max < counts.get(x)) {
				max = counts.get(x);
				key = x;
			}
		}
		return key;

	}
}
