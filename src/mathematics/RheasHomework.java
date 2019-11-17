package mathematics;

import java.math.*;
import java.util.*;

public class RheasHomework {

	public static int mod = 1000000007;

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int[] freq = new int[26];
		long[] rv = new long[26];

		for (int i = 0; i < str.length(); ++i) {
			freq[str.charAt(i) - 'a']++;
		}

		long[] memo = new long[str.length() + 1];

		for (int i = 0; i < 26; ++i) {
			if (freq[i] == 0)
				continue;
			long ans = fact(str.length() - 1, memo);
			if (freq[i] > 0) {
				for (int j = 0; j < 26; ++j) {
					if (j == i) {
						ans = ans / fact(freq[j] - 1, memo);
					} else {
						ans = ans / fact(freq[j], memo);
					}
				}
			}
			rv[i] = ans;
		}

		for (int i = 0; i < 26; ++i) {
			System.out.print(rv[i] + " ");
		}
		s.close();
	}

	long modinverse(int a, int b) {
		BigInteger temp = BigInteger.valueOf(a);
		temp = temp.modInverse(BigInteger.valueOf(b));
		return temp.longValue();

	}

	public static long fact(int n, long[] memo) {
		if (n <= 1)
			return 1;
		else if (memo[n] != 0) {
			return memo[n];
		} else {
			long rv = n * fact(n - 1, memo);
			memo[n] = rv % mod;
			return memo[n];
		}
	}
}
