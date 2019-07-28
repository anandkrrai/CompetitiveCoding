package arraysAndstrings;

import java.util.*;

public class maxInSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> list = new LinkedList<>();
		int[] rv = new int[nums.length - k + 1];

		for (int i = 1; i < k; ++i) {

			while (list.size() != 0 && nums[i] > nums[list.peekLast()]) {
				list.removeLast();
			}
			list.add(i);
		}
		int index = 0;
		rv[index++] = nums[list.peekFirst()];
		for (int i = k; i < nums.length; ++i) {
			while (list.size() != 0 && list.peekFirst() < i - k) {
				list.removeFirst();
			}
			while (list.size() != 0 && nums[i] > nums[list.peekLast()]) {
				list.removeLast();
			}
			list.add(i);
			rv[index++] = nums[list.peekFirst()];

		}
		return rv;
	}
}
