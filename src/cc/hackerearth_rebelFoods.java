package cc;

import java.util.Arrays;
import java.util.Scanner;

public class hackerearth_rebelFoods {
	public static int count(boolean arr[], int vidx) {
		int rv = 0;
		while (vidx < arr.length) {
			if (arr[vidx]) {
				++rv;
			}
			++vidx;
		}
		return rv;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		s.nextLine();
		boolean[] arr = new boolean[31];
		Arrays.fill(arr, false);
		while (n-- > 0) {
			int x = s.nextInt();
			arr[x] = true;
		}
//		int min_cost=0;
//		for (int i = 0; i < 31; ++i) {
//			if()
//		}

		int ans = ret_val(arr, 0);
//		System.out.println(ans);
		System.out.println(Math.min(ans, 2499));
	}

	private static int ret_val(boolean[] arr, int vidx) {
		if (vidx >= arr.length) {
			return 0;
		}
		if (!arr[vidx]) {
			return ret_val(arr, vidx + 1);
		}
		int rv1 = 199 + ret_val(arr, vidx + 1);
		int rv2 = 699 + ret_val(arr, vidx + 7);
		return Math.min(rv1, rv2);
	}

}
