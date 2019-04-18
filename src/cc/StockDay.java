package cc;

public class StockDay {
	public static int stockmax(int[] prices) {
		int[] max = new int[prices.length];
		max[prices.length - 1] = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; --i) {
			max[i] = Math.max(prices[i], max[i + 1]);
		}
		int numShares = 0, profit = 0, buyprice = 0;

		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] < max[i]) {
				++numShares;
				buyprice += prices[i];
			} else {
				profit += prices[i] * numShares - buyprice;
				numShares = 0;
				buyprice = 0;
			}
		}

		return profit;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 4, 5 };
		System.out.println(stockmax(arr));
	}
}
/*
package cc;

import java.util.Scanner;

public class StockDay {
	public static int stockmax(int[] prices) {
		int[] max = new int[prices.length];
		// max[prices.length-1]=prices[prices.length-1];
		max[prices.length - 1] = 0;
		for (int i = prices.length - 2; i >= 0; --i) {
			max[i] = Math.max(prices[i + 1], max[i + 1]);
		}
		int numShares = 0, profit = 0, buyprice = 0;

		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] < max[i]) {
				++numShares;
				buyprice += prices[i];
				// }else if(prices[i]==max[i]){
				// do nothing
			} else if (prices[i] > max[i]) {
				profit += prices[i] * numShares - buyprice;
				numShares = 0;
				buyprice = 0;
			}
		}

		return profit;

	}

	public static void main(String[] args) {
//		int[] arr = { 5, 4, 3, 4, 5 };
//		System.out.println(stockmax(arr));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 1; i < n; ++i) {
			arr[i] = scan.nextInt();
		}
		System.out.println(stockmax(arr));

	}

}
*/