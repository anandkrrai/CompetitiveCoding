package cc;

import java.util.Scanner;

public class chefAndStrangeAddition {
	public static int findSetBits(int n) {
		int rv = 0;
		while (n > 0) {
			if (bits[n] != 0) {
				rv += bits[n];
				break;
			}
			rv += n & 1;
			n >>= 1;
		}
		
		return rv;
	}

	public static int[] bits;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();

			bits = new int[c + 1];
			for (int i = 0; i <= c; ++i) {
				bits[i] = findSetBits(i);
			}

			int num_a_bits = bits[a];
			int num_b_bits = bits[b];

			int count = 0;
			for (int i = 0; i <= c; ++i) {

				if (bits[i] == num_a_bits && bits[c - i] == num_b_bits) {
					++count;
				}
			}

			System.out.println(count);

		}
		scan.close();
	}

}
