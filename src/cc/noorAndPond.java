package cc;

import java.util.Scanner;

public class noorAndPond {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int[] s = new int[n];
			int[] e = new int[n];

			for (int i = 0; i < n; ++i) {
				s[i] = scan.nextInt();
				e[i] = scan.nextInt();
			}

			System.out.println(s[0] + s[1] + s[2]);

		}

		scan.close();
	}

}
