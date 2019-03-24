package cc;

import java.math.*;
import java.util.ArrayList;
import java.util.Scanner;

public class hr_math_paths {

	public static int index(int n, int k) {
		int[] arr = new int[n];
		int i, j, ass = 0, des = n - 1;

		for (i = 0; i < n; i += 2) {
			arr[i] = des;
			--des;
		}
		for (j = 1; j < n; j += 2) {
			arr[j] = ass;
			++ass;
		}

		for (i = 0; i < n; ++i) {
			if (arr[i] == k) {
				return i;
			}
		}
		return -1;
	}

	static String solve(int n, int m) {
		BigInteger bn = new BigInteger(n + "");
		BigInteger bm = new BigInteger(m + "");
		bn = bn.multiply(bm);
		bn = bn.subtract(BigInteger.ONE);
		return bn.toString();

	}

	static long solve(int n, int[][] operations) {
		long[] list = new long[n + 2];
		long rv = 0;

		for (int i = 0; i < operations.length; ++i) {
			list[operations[i][0]] += operations[i][2];
			list[operations[i][1] + 1] -= operations[i][2];

		}
		for (int i = 1; i <= n; ++i) {
			list[i] += list[i - 1];
		}

		for (int i = 1; i <= n; ++i) {
			rv += list[i];
		}

		return rv / n;
	}

	
	public static void main(String[] args) {

		int x = -11;
		System.out.println(x / 7);
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();

			System.out.println(index(n, k));
		}
	}

}
