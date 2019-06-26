package map_set;

//http://134.209.156.168:3004/resource/interview-prep/hashmap-and-heaps2/longest-sub-array-with-sum-k/ojquestion
import java.util.HashMap;

public class longestSubArrayWithSumK {
	public static void print(int n, int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0, ans = 0;

		for (int i = 0; i < n; ++i) {
			sum += arr[i];

			if (map.containsKey(sum - k)) {
				ans = Math.max(ans, i - map.get(sum - k));
			}

			if (!map.containsKey(sum))
				map.put(sum, i);

		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
