package cc;

import java.util.Scanner;

public class gfg_longest_even_substring {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();

		while (t > 0) {
			--t;
			String str = scan.nextLine();
			int[] arr = new int[str.length()];

			for (int i = 0; i < arr.length; ++i) {
				arr[i] = Integer.parseInt(str.charAt(i) + "");
			}
			int maxlen = 0, suml = 0, sumr = 0;
			for (int i = 0; i <= arr.length; ++i) {
				int hi, lo;
				lo = i - 1;
				hi = i;
				suml = 0;
				sumr = 0;
				while (lo >= 0 && hi < arr.length) {
					sumr += arr[hi];
					suml += +arr[lo];
					if (suml == sumr && maxlen < hi - lo + 1) {
						maxlen = hi - lo + 1;
					}
					++hi;
					--lo;
				}
			}

			System.out.println(maxlen);
		}
		scan.close();
	}

}
