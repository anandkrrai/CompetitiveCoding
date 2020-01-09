package arraysAndstrings;

import java.util.*;

public class PowerSet {
	public static void subsetsWithDupHelper(List<List<Integer>> output, List<Integer> curr, int[] nums, int start) {
		// at each recursive call, we want to take in whatever is in curr and addAll to
		// a newly created ArrayList<>() and then put thus new list into ouput
		// then we decide to include the current num and decide to not include
		// whatever curr has now is a subset anyway
		// so add it into the output
		System.out.println(curr + " " + start);
		output.add(new ArrayList<>(curr)); // could also use addAll approach
		for (int i = start; i < nums.length; i++) {
			// now we want to

			curr.add(nums[i]);
			subsetsWithDupHelper(output, curr, nums, i + 1);
			curr.remove(curr.size() - 1);

			// since nums is sorted, we want to skip those same values
			// after subsets till current nums[i] have been generated. In other words,
			// we can not put this while loop before the recursive call.
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				i++; // if the next value is the same, skip it.
		}

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(nums);
		subsetsWithDupHelper(output, new ArrayList<>(), nums, 0);
		return output;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
		int[] arr = { 1, 2, 2, 2, 3 };
		subsetsWithDup(arr);
	}

}
