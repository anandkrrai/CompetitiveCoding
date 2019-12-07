package dp;

public class partitonIntoKSubsetsOfEqualSum {
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length)
			return false;
		if (k == nums.length || k == 1)
			return true;
		int sum = 0;
		for (int val : nums)
			sum += val;
		if (sum % k != 0)
			return false;
		return partition(nums, new boolean[nums.length], 0, 0, k, sum / k);
	}

	public static boolean partition(int[] arr, boolean[] visited, int vidx, int sum, int k, int target) {
		if (k == 1) {
			return true;
		}
		if (sum == target) {
			return partition(arr, visited, 0, 0, k - 1, target);
		}

		for (int i = vidx; i < arr.length; ++i) {
			if (visited[i] == false && sum + arr[i] <= target) {
				visited[i] = true;
				Boolean rv = partition(arr, visited, i, sum + arr[i], k, target);
				visited[i] = false;
				if (rv)
					return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int[] nums = { 29, 28, 51, 85, 59, 21, 25, 23, 70, 97, 82, 31, 85, 93, 73 };
		int k = 3;
		System.out.println(canPartitionKSubsets(nums, k));
	}

}
