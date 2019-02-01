package cc;

import java.util.Scanner;

public class hackerearth_nextLuckyNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine() + "");

		while (n-- > 0) {
			String str = scan.nextLine();
			findNext(str);
		}

		scan.close();
	}

	private static void findNext(String str) {

		int carry = 0, ld;
		String ans = "";
		for (int i = str.length() - 1; i >= 0; --i) {
			ld = Integer.parseInt(str.charAt(i) + "");
			ld += carry;
			if (ld == 4 ) {
				ans = 5 + "" + ans;
				carry = 0;
			} else if (ld > 4) {
				carry = 1;
				ans = 3 + "" + ans;
			} else {
				ans = 3 + "" + ans;
				carry = 0;
			}
		}

		if (carry == 1) {
			System.out.print(3);
		}
		System.out.println(ans);
	}

}
