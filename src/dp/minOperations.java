package dp;

import java.util.Arrays;

public class minOperations {
	static void minOperations1(int n) {
		int[] arr = new int[n + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		for (int i = 0; i <= n; ++i) {
			if (i + 1 <= n) {
				arr[i + 1] = Math.min(arr[i + 1], arr[i] + 1);
			}

			if (i * i <= n) {
				arr[i + 1] = Math.min(arr[i * i], arr[i] + 1);
			}
		}

		// return arr[n];
		System.out.println(arr[n]);
	}

	static void minOperation(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				--n;
			}
			++count;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		minOperation(79);
	}
}
