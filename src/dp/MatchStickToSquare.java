package dp;

public class MatchStickToSquare {
	public boolean makesquare(int[] nums) {
		int sum = 0;
		for (int val : nums)
			sum += val;
		if (sum % 4 != 0)
			return false;

		return find(nums, 0, 0, 4, sum / 4, new boolean[nums.length]);
	}

	public boolean find(int[] nums, int sum, int vidx, int k, int target, boolean[] visited) {
		if (k == 1)
			return true;
		if (sum == target) {
			return find(nums, 0, 0, k - 1, target, visited);
		}
		if (vidx >= nums.length)
			return false;

		for (int i = vidx; i < nums.length; ++i) {
			if (visited[i] == false && nums[i] + sum <= target) {
				visited[i] = true;
				if (find(nums, sum + nums[i], i + 1, k, target, visited))
					return true;
				visited[i] = false;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
