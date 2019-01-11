package cc;

import java.util.Scanner;

public class hackerearth_rebeelfoodsQue1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String str1 = s.nextLine();
		String str2 = s.nextLine();
		s.close();
		int ans = findCount(str1, str2, 0, 0);

		if (ans == 2147483647) {
			System.out.println("Not possible");
		} else {
			System.out.println(ans);
		}
	}

	private static int findCount(String str1, String str2, int vidx1, int vidx2) {
		if (str1.equals(str2)) {
			return 0;
		}

		if (str1.charAt(vidx1) == str2.charAt(vidx2)) {
			return findCount(str1, str2, vidx1 + 1, vidx2 + 1);
		} else {
			String temp;
			int rv1 = Integer.MAX_VALUE, rv2 = Integer.MAX_VALUE, rv3 = Integer.MAX_VALUE, rv4 = Integer.MAX_VALUE;
			if (vidx1 > 0 && str1.charAt(vidx1) == str1.charAt(vidx1 - 1)) {
				temp = str1.substring(0, vidx1) + str1.substring(vidx1 + 1);
				rv1 = 1 + findCount(temp, str2, vidx1, vidx2);
			}
			if (vidx2 > 0 && str2.charAt(vidx2) == str2.charAt(vidx2 - 1)) {
				temp = str2.substring(0, vidx2) + str2.substring(vidx2 + 1);
				rv2 = 1 + findCount(str1, temp, vidx1, vidx2);
			}
			if (vidx1 + 1 < str1.length() && str1.charAt(vidx1) == str1.charAt(vidx1 + 1)) {
				if (vidx1 == str1.length() + 1) {
					temp = str1.substring(0, vidx1 + 1);
				} else {
					temp = str1.substring(0, vidx1 + 1) + str1.substring(vidx1 + 2);
				}
				rv3 = 1 + findCount(temp, str2, vidx1, vidx2);
			}
			if (vidx2 + 1 < str2.length() && str2.charAt(vidx2) == str2.charAt(vidx2 + 1)) {
				if (vidx2 == str2.length() + 1) {
					temp = str2.substring(0, vidx2 + 1);

				} else {
					temp = str2.substring(0, vidx2 + 1) + str2.substring(vidx2 + 2);
				}
				rv4 = 1 + findCount(str1, temp, vidx1, vidx2);
			}
			return Math.min(Math.min(rv1, rv2), Math.min(rv3, rv4));
		}

	}

}
