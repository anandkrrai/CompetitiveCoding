package cc;

import java.util.Arrays;
import java.util.Scanner;

public class ConfusingPrimes {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		boolean[] ayush = new boolean[n + 1];
		boolean[] dev = new boolean[n + 1];

		Arrays.fill(ayush, true);
		Arrays.fill(dev, true);

		int i = 2;
		while (i < n) {
			if (ayush[i] == false)
				continue;

			int j = 2;

			while (j * i <= n) {
				ayush[i * j] = false;
				++j;
			}
		}

	}

}
