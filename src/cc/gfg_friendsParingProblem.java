package cc;

import java.util.Scanner;

public class gfg_friendsParingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long[] dp = new long[n + 1];

			for (int i = 0; i <= n; ++i) {
				if (i <= 2) {
					dp[i] = i;
				} else {
					dp[i] = (dp[i - 1]%1000000007 + ((i - 1) * dp[i - 2]) % 1000000007) % 1000000007;
				}
			}
			System.out.println(dp[n]);
		}
		sc.close();
	}

}
