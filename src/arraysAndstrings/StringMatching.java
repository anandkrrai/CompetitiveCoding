package arraysAndstrings;

import java.util.Scanner;

public class StringMatching {

	public static int[] zAlgo(String str) {
		int[] z = new int[str.length()];
		int i = 0, l = 0, r = 0, k = 0;
		for (i = 1; i < str.length(); ++i) {
			if (i > r) {
				l = r = i;
				while (r < str.length() && str.charAt(r) == str.charAt(r - l))
					++r;
				z[i] = r - l;
				--r;
			} else {
				k = i - l;
				if (z[k] + i < r) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < str.length() && str.charAt(r) == str.charAt(r - l))
						++r;
					z[i] = r - l;
					--r;
				}
			}
		}
		return z;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		String p = sc.nextLine();
		String t = sc.nextLine();
		int[] z = zAlgo(p + "&" + t);

		int rv = 0;
		for (int val : z)
			if (val == p.length())
				++rv;

		System.out.println(rv);
		sc.close();
	}
}