package map_set;

import java.util.HashMap;

//http://134.209.156.168:3004/resource/interview-prep/hashmap-and-heaps2/longest-subarray-with-sum-divisible-by-k/ojquestion
public class longestSubArrayWithSumDivisibleByK {
	public static void print(int n, int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0, ans = 0;

		for (int i = 0; i < n; ++i) {
			sum += arr[i];
			sum = sum % k;
			if (map.containsKey(sum)) {
				ans = Math.max(ans, i - map.get(sum));
			} else {
				map.put(sum, i);
			}

		}
		System.out.println(ans);
	}

}
