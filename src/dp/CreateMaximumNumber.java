package dp;

import java.util.HashMap;

public class CreateMaximumNumber {

	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();

		StringBuilder str1 = new StringBuilder(""), str2 = new StringBuilder("");
		for (int val : nums1)
			str1.append(val + "");
		for (int val : nums2)
			str2.append(val + "");

		fill_map(map1, str1.toString());
		fill_map(map2, str2.toString());

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
		StringBuilder rv = new StringBuilder("");

		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) < str2.charAt(j)) {
				rv.append(str2.charAt(j++));
			} else if (str1.charAt(i) > str2.charAt(j)) {
				rv.append(str1.charAt(i++));
			} else {
				String ans1 = str1.charAt(i) + greater(str1.substring(i + 1), str2.substring(j));
				String ans2 = str2.charAt(j) + greater(str1.substring(i), str2.substring(j + 1));
				if (ans1.compareTo(ans2) > 0) {
					return rv.append(ans1).toString();
				} else {
					return rv.append(ans2).toString();
				}
			}
		}

		if (i < str1.length()) {
			rv.append(str1.substring(i));
		}
		if (j < str2.length()) {
			rv.append(str2.substring(j));
		}

		return rv.toString();

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
		int[] arr1 = { 3, 3, 1, 8, 2, 4, 2, 9, 2, 4, 7, 1, 9, 2, 3, 4, 0, 7, 5, 4 };
		int[] arr2 = { 9, 7, 7, 1, 3, 6, 8, 6, 9, 6, 0, 4, 3, 6, 6, 1, 0, 4, 6, 2, 2, 6, 4, 6, 0, 4, 9, 7, 4, 9, 8, 4,
				9, 8, 4, 6, 6, 5, 8, 2, 8, 6, 6, 6, 1, 0, 9, 0, 8, 0, 4, 0, 4, 4, 1, 7, 9, 8, 4, 2, 2, 0, 3, 2, 3, 9, 1,
				8, 9, 5, 2, 7, 9, 2, 7, 7, 8, 5, 4, 4, 8, 6, 5, 5, 9, 6, 1, 4, 6, 0, 8, 5, 3, 4, 2, 0, 0, 9, 5, 2 };
		int k = 100;

		int[] rv = maxNumber(arr1, arr2, k);
		for (int val : rv)
			System.out.print(val + " ");
	}

}
