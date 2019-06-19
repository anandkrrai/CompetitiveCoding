import java.util.HashMap;
import java.util.Scanner;

public class EqualArray {

	public static boolean isTwoArrayEqual(long[] num1, long[] num2) {
		HashMap<Long, Integer> map = new HashMap<>();

		for (long val : num1) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		for (long val : num2) {
			int ans = map.getOrDefault(val, 0);
			map.remove(val);

			if (ans == 0)
				return false;

			if (ans - 1 > 0)
				map.put(val, ans - 1);

		}
		if (map.size() > 0)
			return false;

		return true;

	}

	// Don't make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long[] num = new long[n];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextLong();
		}
		int m = n;
		long[] arr = new long[m];
		for (int i = 0; i < m; i++) {
			arr[i] = scn.nextLong();
		}
		boolean x = isTwoArrayEqual(num, arr);
		System.out.println(x);
	}
}