package arraysAndstrings;

import java.util.*;

//https://leetcode.com/problems/jump-game/submissions/
public class canJump {
	public boolean canJump(int[] nums) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(0);

		while (list.size() != 0) {
			int i = list.removeFirst();
			if (i == nums.length - 1)
				return true;
			for (int j = 1; j <= nums[i] && i + j < nums.length; ++j) {
				if (i + j == nums.length - 1)
					return true;
				list.addLast(i + j);
			}
		}
		return false;
	}
}
