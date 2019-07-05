package arraysAndstrings;

import java.util.Scanner;

public class playingWithNumbers {
	public static int sieveOfEratosthenes(int n) {

		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i < n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		boolean[] arr = new boolean[n + 1];

		for (int i = 2; i < prime.length; ++i) {
			if (prime[i]) {
				int mul = 1;
				while (mul * i < arr.length) {
					arr[mul * i] = true;
					++mul;
				}
			}

		}

		int count = 0;
		for (int i = 2; i < arr.length; ++i) {
			if (arr[i])
				++count;
		}

		return count;

	}

	public static int countNum(int n) {
		boolean[] arr = new boolean[n + 1];
		int[] pa = { 2, 3, 5, 7 };
		int rv = 0;
		for (int i = 0; i < pa.length; ++i) {
			int mul = 1;
			while (pa[i] * mul < arr.length) {
				arr[pa[i] * mul] = true;
				++mul;
			}
		}

		for (int i = 2; i < arr.length; ++i) {
			if (arr[i])
				++rv;
		}

		return rv;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = countNum(n);
		System.out.print(x);

	}
}
