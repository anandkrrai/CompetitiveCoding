package cc;

import java.util.Scanner;

public class lenskart_sde2_q2 {

//	https://www.hackerearth.com/challenge/hiring/Lenskart-SDE2-Hiring-Challenge/problems/d664958c1f5c4b059f1ca5105f016f7f/

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextLong();
			}

			double d = Math.pow(2, n - 1);
			int mod = 1000000007, ans = 0;
			for (int i = 0; i < n; ++i) {
				if (arr[i] >= d) {
					ans += arr[i];
					ans %= mod;
				}
			}

			System.out.println(ans);
		}
		scan.close();
	}

}
