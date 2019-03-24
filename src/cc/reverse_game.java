package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class reverse_game {

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

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();

			System.out.println(index(n, k));
		}
	}

}

