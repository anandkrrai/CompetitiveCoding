package map_set;

import java.util.HashMap;

public class subsetsDivisibleByK {
	public static  int subarraysDivByK(int[] arr, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0, ans = 0;

		for (int i = 0; i < arr.length; ++i) {
			sum += arr[i] % k;
			sum = sum % k;
			ans += map.getOrDefault(sum, 0);
			map.put(sum, 1 + map.getOrDefault(sum, 0));

		}
		return ans;
	}

	
	
	public static void main(String[] args) {
		int[] arr = { 4, 5, 0, -2, -3, 1 };
		int k=5;
		
		System.out.println(subarraysDivByK(arr, k));
	}

}
