package cc;

import java.util.Scanner;

public class gfg_kSmalest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			int k = scan.nextInt();
//			Arrays.sort(arr);
			findSets(arr, k);
			System.out.println();
		}
		scan.close();
	}

}
