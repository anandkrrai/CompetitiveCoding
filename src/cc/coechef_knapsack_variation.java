package cc;

import java.util.Scanner;

public class coechef_knapsack_variation {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] weight = new int[n], cost = new int[n];
		for (int i = 0; i < n; ++i) {
			weight[i] = scan.nextInt();
			cost[i] = scan.nextInt();
		}

		kp(weight, cost);
		scan.close();

	}

	public static void kp(int[] weight, int[] cost) {
		int capacity = 0;
		for (int i = 0; i < weight.length; ++i) {
			capacity += weight[i];
		}
		int[][] dp = new int[weight.length + 1][capacity + 1];

		for (int c = 0; c < dp.length; ++c) {
			for (int w = 0; w < dp[0].length; ++w) {
				if (w == 0 || c == 0) {
					dp[c][w] = 0;
				} else {
					
					dp[c][w] = dp[c - 1][w];
					
					if (weight[c - 1] <= w) {
						dp[c][w] = Math.max(dp[c - 1][w - weight[c - 1]] + cost[c - 1], dp[c][w]);
					}
				}
			}
		}

		for (int i = 1; i < dp[0].length; ++i) {
			System.out.print(dp[dp.length - 1][i] + " ");
		}
	}

//	public static void kp(int[] weight, int[] cost) {
//		int capacity = 0;
//		for (int i = 0; i < weight.length; ++i) {
//			capacity += weight[i];
//		}
//		int[][] dp = new int[weight.length + 1][capacity + 1];
//
//		for (int c = 0; c < dp.length; ++c) {
//			for (int w = 0; w < dp[0].length; ++w) {
//				if (w == 0 || c == 0) {
//					dp[c][w] = 0;
//				} else if (weight[c - 1] <= w) {
//					dp[c][w] = Math.max(dp[c - 1][w - weight[c - 1]] + cost[c - 1], dp[c - 1][w]);
//				} else {
//					dp[c][w] = dp[c - 1][w];
//				}
//			}
//		}
//
//		for (int i = 1; i < dp[0].length; ++i) {
//			System.out.print(dp[dp.length - 1][i] + " ");
//		}
////		System.out.println(dp[dp.length - 1][dp[0].length - 1] + " ");
//	}

}
