
import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner scan = new Scanner(System.in);

		int x = scan.nextInt();
		int n = scan.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = scan.nextInt();
		}

		int[][] min = new int[n][n];

		for (int i = 0; i < n; ++i) {
			int mi = arr[i];
			for (int j = i; j < n; ++j) {
				mi = Math.min(mi, arr[j]);
				min[i][j] = mi;
			}
		}

		HashMap<String, Long> map = new HashMap<>();

		long ans = find(arr, 0, x, min, map);
		System.out.println(ans);

	}

	public static long find(int[] arr, int vidx, int k, int[][] min, HashMap<String, Long> map) {
		long rv = Integer.MIN_VALUE;
		String str = vidx + " " + k;

		if (k == 1) {
			return min[vidx][arr.length - 1];
		}
		if (map.containsKey(str))
			return map.get(str);
		for (int i = vidx; i <= arr.length - k; ++i) {
			long temp = min[vidx][i] + find(arr, i + 1, k - 1, min, map);
			rv = Math.max(temp, rv);
		}
		map.put(str, rv);
		return rv;
	}
}
