package cc;

import java.util.*;

public class gfg_interleaved {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();

			System.out.println(isInterLeave(a, b, c) == true ? 1 : 0);
			t--;
		}
		sc.close();
	}

	public static boolean isInterLeave(String a, String b, String c) {
		if (c.length() == 0 && b.length() == 0 && a.length() == 0) {
			return true;
		}

		boolean rv1 = false, rv2 = false;
		if (a.length() != 0 && a.charAt(0) == c.charAt(0)) {
			rv1 = isInterLeave(a.substring(1), b, c.substring(1));
		}
		if (b.length() != 0 && b.charAt(0) == c.charAt(0)) {
			rv2 = isInterLeave(a, b.substring(1), c.substring(1));
		}

		return rv1 || rv2;

	}

}
