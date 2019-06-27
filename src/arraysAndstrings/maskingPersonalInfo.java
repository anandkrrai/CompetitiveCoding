package arraysAndstrings;

import java.util.Scanner;

public class maskingPersonalInfo {
	public static String maskPII(String s) {

		s = s.toLowerCase();
		char ch = s.charAt(0);
		String rv = "";
		if (ch - 'a' >= 0 && 'z' - ch >= 0) {
			String[] arr = s.split("@");
			rv = arr[0].charAt(0) + "*****" + arr[0].charAt(arr[0].length() - 1) + "@" + arr[1];
		} else {
			int count = 0;
			String str = "";

			for (int i = 0; i < s.length(); ++i) {
				ch = s.charAt(i);
				if (ch - '0' >= 0 && '9' - ch >= 0) {
					str += ch;
					++count;
				}
			}
			if (count > 10) {
				rv = "+**-";
			} else {
				rv += "+-";
			}
			rv += "***-***-";
			System.out.println(str);
			rv += str.substring(str.length() - 4);
		}
		return rv;
	}

	public static int shortestWordDistance(String[] words, String word1, String word2) {
		int w1 = -1, w2 = -1, ans = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; ++i) {
			if (words[i].equals(word1)) {
				if (w1 != -1 && w2 != -1) {
					ans = Math.min(ans, i - w2);
				}
				w1 = i;
			} else if (words[i].equals(word1)) {
				if (w1 != -1 && w2 != -1) {
					ans = Math.min(ans, i - w1);
				}
				w2 = i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.print(maskPII(str));
	}
}
