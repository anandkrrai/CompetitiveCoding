package cc;

import java.math.BigInteger;
import java.util.*;

class gfg_perfectSumProblem {

	public static void findSets(int[] arr, int k) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		helper(arr, 0, k, 0, "(", map);
		System.out.println(map.size());
	}

	public static void helper(int[] arr, int vidx, int k, int sum, String ans, HashMap<String, Boolean> map) {
		if (k == sum) {
			String key = ans + ")";
			if (map.containsKey(key))
				return;
			map.put(key, true);
//			System.out.println(key);
			return;
		}

		if (vidx >= arr.length || sum > k) {
			return;
		}

		helper(arr, vidx + 1, k, sum + arr[vidx], ans + "" + arr[vidx] + " ", map);
		helper(arr, vidx + 1, k, sum, ans, map);
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		BigInteger bigInteger = new BigInteger("1232");
		String str = bigInteger.multiply(bigInteger).toString();
		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			int k = scan.nextInt();
//			Arrays.sort(arr);
			findSets(arr, k);
			System.out.println();
		}
		scan.close();
	}
}
