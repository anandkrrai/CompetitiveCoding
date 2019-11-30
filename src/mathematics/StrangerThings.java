package mathematics;

import java.util.*;

// https://www.hackerearth.com/practice/math/combinatorics/inclusion-exclusion/practice-problems/algorithm/thl-cake1/

//Prime number hone chiye arr mai!!!!
public class StrangerThings {
	public static long ans;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		boolean[] bool = new boolean[25];
		fill_sieve(bool);

		while (t-- > 0) {
			int k = s.nextInt();
			ans = 0;
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < k; ++i) {
				int x = s.nextInt();
				for (int o = 2; o <= x; ++o)
					if (bool[o] && x % o == 0)
						set.add(o);
			}
			int[] arr = new int[set.size()];
			int ind = 0;
			for (int val : set) {
				arr[ind++] = val;
			}
			long n = s.nextLong();
			findAns(arr, 0, 0, 1, n);
			System.out.println(ans);
		}

		s.close();
	}

	private static void fill_sieve(boolean[] bool) {
		Arrays.fill(bool, true);
		bool[0] = bool[1] = false;

		for (int i = 2; i < bool.length; ++i) {
			if (!bool[i])
				continue;

			for (int j = i + i; j < bool.length; j += i) {
				bool[j] = false;
			}
		}
	}

	private static void findAns(int[] arr, int vidx, int len, long prod, long n) {
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

		findAns(arr, vidx + 1, len, prod, n);
		findAns(arr, vidx + 1, len + 1, prod * arr[vidx], n);
	}

}
