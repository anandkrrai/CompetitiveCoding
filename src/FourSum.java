import java.util.*;

public class FourSum {

//	public static List<List<Integer>> fourSum(int[] nums, int target) {
//
//		Arrays.sort(nums);
//		List<List<Integer>> list = new ArrayList<>();
//
//		for (int i = 0; i < nums.length; ++i) {
//			if (i > 0 && nums[i] == nums[i - 1]) {
//				continue;
//			}
//			for (int j = i + 1; j < nums.length; ++j) {
//				if (j > i + 1 && nums[j] == nums[j - 1]) {
//					continue;
//				}
//				int left = j + 1, right = nums.length - 1;
//
//				while (left < right) {
//					int sum = nums[i] + nums[j] + nums[left] + nums[right];
//					if (sum == target) {
//						ArrayList<Integer> l = new ArrayList<>();
//						l.add(nums[i]);
//						l.add(nums[j]);
//						l.add(nums[left]);
//						l.add(nums[right]);
//						list.add(l);
//					} else if (sum > target) {
//						--right;
//					} else {
//						++left;
//					}
//					while (left < right && nums[left] == nums[left - 1]) {
//						++left;
//					}
//					while (left < right && nums[right] == nums[right - 1]) {
//						--right;
//					}
//				}
//			}
//		}
//
//		return list;
//	}
	

public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int sumReq = target - (nums[i] + nums[j]);
				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					int sum = nums[left] + nums[right];
					if (sum < sumReq) {
						left++;
					} else if (sum > sumReq) {
						right--;
					} else {
						ArrayList<Integer> l = new ArrayList<>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[left]);
						l.add(nums[right]);
						list.add(l);
						++left;
						--right;

						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						
					}
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, -1, 0, -2, 2 };
		fourSum(arr, 0);

	}

}
