package dp;

import java.util.HashMap;

public class CreateMaximumNumber {

	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();

		String str1 = "", str2 = "";
		for (int val : nums1)
			str1 += val;
		for (int val : nums2)
			str2 += val;

		fill_map(map1, str1);
		fill_map(map2, str2);

		String rv = "";

		for (int i = 0; i <= k; ++i) {
			if (map1.containsKey(i) && map2.containsKey(k - i)) {
				String str = greater(map1.get(i), map2.get(k - i));
				if (str.compareTo(rv) > 0) {
					rv = str;
				}
			}
		}

		int[] arr = new int[k];
		for (int i = 0; i < k; ++i)
			arr[i] = rv.charAt(i) - '0';
		return arr;
	}

	public static String greater(String str1, String str2) {
		int i = 0, j = 0;
		String rv = "";

		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) < str2.charAt(j)) {
				rv += str2.charAt(j++);
			} else if (str1.charAt(i) > str2.charAt(j)) {
				rv += str1.charAt(i++);
			} else {
				String ans1 = str1.charAt(i) + greater(str1.substring(i + 1), str2.substring(j));
				String ans2 = str2.charAt(j) + greater(str1.substring(i), str2.substring(j + 1));
				if (ans1.compareTo(ans2) > 0) {
					return rv + ans1;
				} else {
					return rv + ans2;
				}
			}
		}

		if (i < str1.length()) {
			rv += str1.substring(i);
		}
		if (j < str2.length()) {
			rv += str2.substring(j);
		}

		return rv;

	}

	public static void fill_map(HashMap<Integer, String> map, String str) {
		map.put(str.length(), str);
		map.put(0, "");
		while (str.length() != 0) {
			String st = str.substring(1);
			for (int i = 0; i < str.length(); ++i) {
				String sub = str.substring(0, i) + str.substring(i + 1);
				if (sub.compareTo(st) > 0)
					st = sub;
			}
			str = st;
			map.put(str.length(), str);
		}

	}

	public static void main(String[] args) {
		System.out.println("00".compareTo("06"));
		int[] arr1 = { 2, 5, 6, 4, 4, 0 };
		int[] arr2 = { 7, 3, 8, 0, 6, 5, 7, 6, 2 };
//		7 3 8 2 5 6 4 4 0 0 6 5 7 6 2 
		int k = 15;

		int[] rv = maxNumber(arr1, arr2, k);
		for (int val : rv)
			System.out.print(val + " ");
	}

}
