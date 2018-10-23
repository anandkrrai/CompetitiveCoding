package cc;

import java.util.Scanner;

public class Bit1 {

	public static int findSetBits(int n) {
		int rv = 0;
		while (n > 0) {
			rv += n & 1;
			n >>= 1;
		}
		return rv;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();

			int num_a_bits = findSetBits(a);
			int num_b_bits = findSetBits(b);

			int num_i_bits, num_c_minus_i_bits;
			int count = 0;
			for (int i = 0; i <= c; ++i) {
				num_i_bits = findSetBits(i);
				num_c_minus_i_bits = findSetBits(c - i);

				if (num_i_bits == num_a_bits && num_c_minus_i_bits == num_b_bits) {
					++count;
				}
			}

			System.out.println(count);

		}
		scan.close();
	}

}
