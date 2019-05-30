package cc;

import java.util.Scanner;

public class multiple_sum3and5 {

	static long sumAP(long n, long d) {
		n /= d;
		return (n) * (1 + n) * d / 2;
	}

	static long sumMultiples(long n) {
		n--;
		return sumAP(n, 3) + sumAP(n, 5) - sumAP(n, 15);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(sumMultiples(n));
		}

		in.close();
	}
}
