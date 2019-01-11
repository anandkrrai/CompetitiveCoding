package cc;

import java.util.Scanner;

public class hackerearth_BoBanIdiot {
	public static void main(String args[]) {

		// Scanner
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();

		int[] arr = new int[26];
		for (int i = 0; i < 26; ++i) {
			arr[i] = i;
		}

		String str;
		while (t-- > 0) {
			str = s.nextLine();
			int ch1 = str.charAt(0) - 65, ch2 = str.charAt(2) - 65;
			int i = 0, j = 0;
			for (i = 0; i < 26; ++i) {
				if (ch1 == arr[i]) {
//					arr[i] = ch2;
					break;
				}
			}
			for (j = 0; j < 26; ++j) {
				if (ch2 == arr[j]) {
//					arr[i] = ch1;
					break;
				}
			}
			arr[i] = ch2;
			arr[j] = ch1;
		}

		str = s.nextLine();
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) >= 97) {
				System.out.print((char) (arr[str.charAt(i) - 97] + 97));
			} else {
				System.out.print((char) (arr[str.charAt(i) - 65] + 65));
			}
		}
		s.close();
	}
}
