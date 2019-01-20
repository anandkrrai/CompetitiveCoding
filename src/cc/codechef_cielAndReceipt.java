package cc;

import java.util.Scanner;

public class codechef_cielAndReceipt {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		while (n-- > 0) {
			int temp = scan.nextInt();
			System.out.println(findMenu(temp));
		}
	}

	private static int findMenu(int num) {
		int rv = 0;
		int mul = 1, div = 1;
		while (mul < num && mul < 2048) {
			mul *= 2;
		}
		while (num != 0) {
			while (mul > num) {
				mul /= 2;
			}
			div = num / mul;
			num = num - div * mul;
			rv += div;

		}
		return rv;
	}

}
