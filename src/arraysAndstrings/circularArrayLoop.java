package arraysAndstrings;

import java.util.HashSet;

public class circularArrayLoop {
	public static boolean circularArrayLoop(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {

			if (nums[i] % nums.length == 0)
				continue;

			int in = (i + nums[i] + nums.length) % nums.length;

			while (nums[in] * nums[i] > 0) {
				if (set.contains(i))
					break;
				in = (in + nums[in] + nums.length) % nums.length;
				if (i == in)
					return true;
				
				set.add(in);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { -1, -2, -3, -4, -5 };
		System.out.print(circularArrayLoop(nums));
	}

}
