package cc;

import java.util.Scanner;

public class CodingClubAndChocolates {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int c = scan.nextInt();

			int i = 0;
			while (c > i) {
				++i;
				--n;
				c -= i;

			}
			System.out.println(n);

		}

		scan.close();
	}

}
