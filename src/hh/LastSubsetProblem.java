package hh;

import java.math.BigInteger;
import java.util.*;

public class LastSubsetProblem {
	static void sieveOfEratosthenes(boolean[] prime) {
		int n = prime.length - 1;
		for (int i = 0; i < n; i++)
			prime[i] = true;
		prime[0] = prime[1] = false;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}
	}

	public static boolean prime[] = new boolean[100003];
	public static boolean done = false;

	public static int solve(ArrayList<Integer> A) {
		if (!done) {
			done = true;
			sieveOfEratosthenes(prime);
		}
		BigInteger rv = new BigInteger("1");
		BigInteger mod = new BigInteger("1000000007");

		for (int i = 0; i < A.size(); ++i) {
			BigInteger local = new BigInteger("1");
			for (int j = i; j < A.size(); ++j) {
				if (prime[A.get(j)] == true) {
					System.out.print(A.get(j) + " ");
//					local = (local * A.get(j)) % mod;
//					rv = (rv * local) % mod;
					local=local.multiply(BigInteger.valueOf(A.get(j)));
					local=local.mod(mod);
					rv=rv.multiply(local);
					rv=rv.mod(mod);
				}
			}
			System.out.println();

		}
		rv = rv.mod(mod);
		return rv.intValue();
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = { 1, 2, 2, 3, 1, 5, 5, 8, 8, 8 };
		for (int val : arr)
			list.add(val);
		System.out.println(solve(list));
		System.out.println(2&4&9);
	}

}
