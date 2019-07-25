package arraysAndstrings;

import java.util.HashMap;

public class magicArray {

	public static boolean isMagical(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		for (int key : map.keySet()) {
			if (k == 2 * key) {
				if (map.containsKey(key) && map.get(key) >= 2)
					return true;
			} else {
				if (map.containsKey(k - key))
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = {4,3,8,1,9};
		int k=8;
		System.out.println(isMagical(arr, k));
	}

}
