package cc;

import java.util.Scanner;

public class luckBalance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] l = new int[n];
		int[] t = new int[n];

		for (int i = 0; i < n; ++i) {
			l[i] = scan.nextInt();
			t[i] = scan.nextInt();
		}

		System.out.println(checkLuck(l, t, 0, k));
		scan.close();
	}

	private static int checkLuck(int[] l, int[] t, int vidx, int k) {
		if (k < 0)
			return 0;
		
		if (vidx == l.length)
			return 0;

		int rv;
		if (t[vidx] == 0) {
			rv = checkLuck(l, t, vidx + 1, k) + l[vidx];
		} else {
			rv = Math.max(checkLuck(l, t, vidx + 1, k-1) + l[vidx], checkLuck(l, t, vidx + 1, k ) - l[vidx]);
		}

		return rv;
	}

}
