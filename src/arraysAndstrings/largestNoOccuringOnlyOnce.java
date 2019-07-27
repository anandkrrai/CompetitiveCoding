package arraysAndstrings;

import java.util.Arrays;
import java.util.HashMap;

public class largestNoOccuringOnlyOnce {
	public static int largestUniqueNumber1(int[] arr) {
		Arrays.sort(arr);
		int i = arr.length - 1, j = arr.length - 2;
		if (i == 0) {
			return arr[i];
		} else if (i == 1) {
			if (arr[i] == arr[j])
				return -1;
			else
				return arr[i];
		}

		while (j >= 0) {
			if (arr[i] != arr[j]) {
				return arr[i];
			}
			while (j >= 0 && arr[i] == arr[j]) {
				--j;
			}
			i = j;
			--j;
		}
		return -1;
	}

	public static int largestUniqueNumber(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=0;++i) {
			if(map.get(arr[i])==1)
				return arr[i];
		}
			return -1;
		}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 5 };
		System.out.println(largestUniqueNumber(arr));
	}

}
