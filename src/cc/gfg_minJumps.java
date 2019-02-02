package cc;

import java.util.Arrays;
import java.util.Scanner;

public class gfg_minJumps {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) {
				a[i] = scan.nextInt();
			}
			System.out.println(minJump_dp(a));
		}
	}

//	private static int minJump_greedy(int[] arr) {
//		int steps=0;
//		int i=0,max;
//		while(true) {
//			max=0;
//			for(int j=i+1;j<arr.length&&j<=i+arr[i];++j) {
//				max=Math.max(max, arr[j]);
//			}
//			
//		}
//		
//		return steps;
//	}

	private static int minJump_dp(int[] arr) {

		Integer[] dp = new Integer[arr.length];
		dp[arr.length - 1] = 0;

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < arr.length && j <= i + arr[i]; ++j) {
				if (dp[j] != null) {
					if (dp[i] == null) {
						dp[i] = dp[j] + 1;
					} else {
						dp[i] = Math.min(dp[i], dp[j]+1);
					}
				}
			}
		}
		if (dp[0] == null)
			return -1;
		else
			return dp[0];

	}

}
