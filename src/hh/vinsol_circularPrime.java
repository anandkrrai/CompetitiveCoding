package hh;

import java.util.*;

public class vinsol_circularPrime {

	public static void sieve(boolean[] arr) {
		int upLimint = (int) Math.sqrt(arr.length) + 1;
		Arrays.fill(arr, true);
		arr[0] = arr[1] = false;
		for (int i = 2; i < upLimint; ++i) {
			if (arr[i] == false)
				continue;
			for (int j = 2; j * i < arr.length; ++j) {
				arr[i * j] = false;
			}
		}
	}

	public static boolean isCircularPrime(int n, boolean[] arr) {
		int temp = n;
		String s = n + "";
		int digits = s.length();

		while (digits-- > 0) {
			s = s.substring(1) + s.charAt(0);
			temp = Integer.parseInt(s);
			if (arr[temp] == false)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		boolean[] arr = new boolean[10000];
		sieve(arr);
		int count = 0;

		for (int i = 0; i < arr.length; ++i) {
			if (isCircularPrime(i, arr)) {
				System.out.print(i + " ");
				++count;
			}
		}
		System.out.println();

		System.out.println("number of circular primes (repetitions considered): " + count);

	}

}
