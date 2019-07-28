package hh;

import java.util.*;

public class Triplets {
	static void maxTriplet(int a[], int n) {
		// Flag Array initially set to true
		// for all numbers
		boolean[] f = new boolean[n];
		Arrays.fill(f, true);

		// 2D array for bit representation
		// of all the numbers.
		// Initially all bits are set to 0.
		int bits[][] = new int[n][33];

		for (int i = 0; i < n; ++i) {
			int num = a[i];
			int j = 32;

			// Finding bit representation
			// of every number and
			// storing it in bits array.
			while (num > 0) {
				// Checking last bit of the number
				if (num % 2 == 1) {
					bits[i][j] = 1;
				}

				j--;

				// Dividing number by 2.
				num >>= 1;
			}
		}

		// maximum And number initially 0.
		long ans = 0;

		// Traversing the 2d binary representation.
		// 0th index represents 32th bits
		// while 32th index represents 0th bit.
		for (int i = 0; i <= 32; ++i) {
			int cnt = 0;

			for (int j = 0; j < n; ++j) {
				if (bits[j][i] == 1 & f[j]) {
					cnt++;
				}
			}

			// If cnt greater than 3 then (32-i)th bits
			// of the number will be set.
			if (cnt >= 4) {

				ans += Math.pow(2, 32 - i);

				// Setting flags of the numbers
				// whose ith bit is not set.
				for (int j = 0; j < n; ++j) {
					if (bits[j][i] != 1) {
						f[j] = false;
					}
				}
			}
		}

		// Counting the numbers whose flag are true.
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			if (f[i]) {
				cnt++;
			}
		}

		long NumberOfTriplets = (cnt * (cnt - 1) * (cnt - 2)) / 6;

		System.out.print(NumberOfTriplets + " " + ans);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 18, 15, 16, 7, 127, 3, 83, 31, 23, 31 };
		maxTriplet(arr, arr.length);
	}
}
