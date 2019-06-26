package arraysAndstrings;

public class maxConsiquitiveOne {
	public static int findMaxConsecutiveOnes(int[] nums) {

		int start = 0, end = 0, ans = 0;
		boolean flag = false;

		while (end < nums.length) {
			if (nums[end] == 1) {
				++end;
				ans = Math.max(end - start, ans);
			} else {
				if (!flag) {
					flag = true;
					++end;
					ans = Math.max(end - start, ans);
				} else {
					while (start <= end) {
						if (nums[start] == 1) {
							++start;
						} else {
							flag = false;
							++start;
							break;
						}
					}
				}
			}
		}

		return ans;
	}
}
