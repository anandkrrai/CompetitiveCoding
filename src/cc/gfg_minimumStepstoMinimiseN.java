package cc;

import java.util.Scanner;

public class gfg_minimumStepstoMinimiseN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] dp = new int[n + 1];

			for (int i = 0; i <= n; ++i) {
				if (i == 1 || i == 0) {
					dp[i] = 0;
				} else if (i <= 3) {
					dp[i] = 1;
				} else {
					dp[i] = dp[i - 1] + 1;
					if (i % 3 == 0) {
						dp[i] = Math.min(dp[i], dp[i / 3] + 1);
					}

					if (i % 2 == 0) {
						dp[i] = Math.min(dp[i], dp[i / 2] + 1);

					}
				}
			}

			System.out.println(dp[n]);
		}
		sc.close();
	}

}
