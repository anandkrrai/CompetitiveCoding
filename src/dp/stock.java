package dp;

public class stock {
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public int maxProfit_1(int[] prices) {
		if (prices.length == 0)
			return 0;
		int[] arr = new int[prices.length];

		for (int i = 1; i < arr.length; ++i) {
			arr[i] = prices[i] - prices[i - 1];
		}

		int max = 0, rv = 0;

		for (int i = 0; i < arr.length; ++i) {
			max += arr[i];
			rv = Math.max(rv, max);
			if (max < 0)
				max = 0;
		}
		return rv;
	}

//	 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	public int maxProfit__2(int[] prices) {
		if (prices.length == 0)
			return 0;
		int rv = 0;
		for (int i = 1; i < prices.length; ++i) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				rv += diff;
			}
		}
		return rv;
	}

//	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	public static int maxProfit_3(int prices[]) {
		if (prices.length == 0)
			return 0;
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

//	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

	public int maxProfit(int k, int[] prices) {
		if (k == 0 || prices.length == 0)
			return 0;
		int[][] arr = new int[k][prices.length];

		for (int i = 0; i < k; ++i) {
			int min = prices[i * 2 + 1];
			for (int j = 2 * i + 2; j < prices.length; ++j) {
				arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - 1] + prices[j] - min);
				min = Math.min(min, prices[j]);
			}
		}
		return arr[arr.length - 1][arr[0].length - 1];
	}

//	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

	public int maxProfit(int[] arr, int fees) {
		int[] mpb = new int[arr.length];
		int[] mps = new int[arr.length];

		mpb[0] = -arr[0];

		for (int i = 1; i < arr.length; ++i) {
			mpb[i] = Math.max(mpb[i - 1], mps[i - 1] - arr[i]);
			mps[i] = Math.max(mps[i - 1], mpb[i - 1] + arr[i] - fees);
		}

		return mps[arr.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
