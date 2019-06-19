import java.util.HashMap;

//http://134.209.156.168:3004/resource/interview-prep/hmap-and-heaps/subarray-range-with-given-sum/ojquestion
public class SubArraySumWithK {
	static int subArraySum(int arr[], int n, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0, sum = 0;
		for (int val : arr) {
			sum += val;
			count += map.getOrDefault(sum - target, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
