package cc;

import java.util.HashSet;
import java.util.Scanner;

public class largestPrimeFactor {
	public static void sieve(boolean[] arr) {
		arr[0] = arr[1] = true;
		for (int i = 2; i < arr.length; ++i) {
			if (arr[i] == true)
				continue;

			for (int j = 2; j * i < arr.length; ++j) {
				arr[i * j] = true;
			}
		}
	}

	public static boolean isPrime(long x) {
		if (set.contains(x))
			return true;
		for (long i = 2; i * i <= x; ++i) {
			if (x % i == 0)
				return false;
		}
		set.add(x);
		return true;
	}

	public static HashSet<Long> set;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		set = new HashSet<Long>();
		boolean[] arr = new boolean[1000000000];
		sieve(arr);
		for (long i = 0; i < arr.length; ++i) {
			if (!arr[(int) i]) {
				set.add(i);
			}
		}
		arr = new boolean[0];
		int t = in.nextInt();
		while (t-- > 0) {
			long n = in.nextLong();
			if (isPrime(n)) {
				System.out.println(n);
				continue;
			}
			long x = n / 2;
			++x;
			for (long i = x; i >= 2; --i) {
				if (n % i == 0 && isPrime(i)) {
					System.out.println(i);
					break;
				}
			}
		}
		in.close();
	}
}
