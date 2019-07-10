package dp;

import java.util.*;

public class bestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int[] prices = new int[n];
//		for (int i = 0; i < n; i++) {
//			prices[i] = scn.nextInt();
//		}
		scn.close();

		int[] prices = { 8, 6, 4, 7, 11, 15, 10, 6, 3, 5, 7, 10, 11, 18, 12, 10 };
		System.out.print(maxProfit(prices));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and its size
	// It should return the required output

	public static int maxProfit(int prices[]) {
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		int minsf = prices[0], maxsf = prices[prices.length - 1];

		for (int i = 1; i < prices.length; ++i) {
			minsf = Math.min(prices[i], minsf);
			left[i] = Math.max(prices[i] - minsf, left[i - 1]);
		}

		for (int i = prices.length - 2; i >= 0; --i) {
			maxsf = Math.max(maxsf, prices[i]);
			right[i] = Math.max(maxsf - prices[i], right[i + 1]);
		}

		int rv = 0;
		for (int i = 0; i < prices.length; ++i) {
			rv = Math.max(rv, left[i] + right[i]);
		}
		return rv;
	}

}
