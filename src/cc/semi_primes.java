package cc;

import java.util.Arrays;
import java.util.Scanner;

public class semi_primes {

	private static void fillBooleanrray(boolean[] prime_array) {
		Arrays.fill(prime_array, true);
		prime_array[0] = prime_array[1] = false;

		int num_mul = 1;
		while (num_mul < 200) {
			++num_mul;

			if (prime_array[num_mul] == false) {
				continue;
			}

			for (int i = 2; num_mul * i <= 200; ++i) {
				prime_array[num_mul * i] = false;
			}
		}
	}

	public static void main(String[] args) {

		boolean[] prime_array = new boolean[201];
		fillBooleanrray(prime_array);

//		System.out.println(prime_array[199]);

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			--t;

		
		}
		

	}

}
