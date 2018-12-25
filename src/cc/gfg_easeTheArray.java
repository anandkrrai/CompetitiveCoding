package cc;
/*package whatever //do not write package name here */

import java.util.*;

class gfg_easeTheArray {
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

			int prev = 0;
			for (int curr = 1; curr < n; ++curr) {
				if (arr[curr] != 0 && arr[prev] == arr[curr]) {
					arr[prev] *= 2;
					arr[curr] = 0;
					++curr;
				}
				prev = curr;
			}

			int cursor = 0;
			for (int i = 0; i < n; ++i) {
				if (arr[i] != 0) {
					System.out.print(arr[i] + " ");
					++cursor;
				}
			}

			for (int i = cursor; i < n; ++i) {
				System.out.print("0 ");

			}

			System.out.println();

		}

		scan.close();
	}
}