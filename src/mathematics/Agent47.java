package mathematics;

import java.util.*;

public class Agent47 {
	public static long ans;

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {
			ans = 0;
			long n = s.nextLong();
			int p = s.nextInt();

			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < p; ++i) {
				set.add(s.nextInt());
			}
			int[] arr = new int[set.size()];
			int k = 0;
			for (int val : set) {
				arr[k++] = val;
			}
			findAns(arr, n, 1, 0, 0);
			System.out.println(ans);
		}
		s.close();
	}

	private static void findAns(int[] arr, long n, long prod, int vidx, int len) {

		if (vidx == arr.length) {
			if (len == 0) {
				// do nothing
			} else if (len % 2 == 0) {
				ans -= n / prod;
			} else {
				ans += n / prod;
			}
			return;
		}

		findAns(arr, n, prod, vidx + 1, len);
		findAns(arr, n, prod * arr[vidx], vidx + 1, len + 1);
	}
}
