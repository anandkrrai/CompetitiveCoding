package arraysAndstrings;

import java.util.Scanner;

public class shiftLettersByn {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		String str = scan.nextLine();
//		int n = scan.nextInt();
		String str="abcdefz";
		int n =260000;
		str = shift(str, n);
		System.out.println(str);
		scan.close();
	}

	private static String shift(String str, int n) {
		n = n % 26;
		String rv = "";
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			int asci = ch + n;
			if (asci > 122) {
				asci = asci % 123;
				rv += (char) ('a' + asci);
			} else {
				rv += (char) (asci);
			}
		}

		return rv;
	}

}
