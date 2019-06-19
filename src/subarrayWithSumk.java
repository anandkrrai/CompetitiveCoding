import java.util.HashMap;

public class subarrayWithSumk {
	static int subarraysDivByK(int arr[], int target) {

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0, sum = 0, mod;
		for (int val : arr) {
			sum += val;
			mod = sum % target;
			if (mod < 0)
				mod += target;
			count += map.getOrDefault(mod, 0);
			map.put(mod, map.getOrDefault(mod, 0) + 1);
		}

		return count;
	}
}
