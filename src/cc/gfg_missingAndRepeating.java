package cc;

import java.util.Scanner;

public class gfg_missingAndRepeating {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int temp;
			int[] arr = new int[n + 1];

			for (int i = 0; i < n; ++i) {
				temp = scan.nextInt();
				arr[temp]++;
			}
			int repeating = 0, missing = 0;
			for (int i = 1; i < arr.length; ++i) {
				if (arr[i] >= 2) {
					repeating = i;
				} else if (arr[i] == 0) {
					missing = i;
				}

				if (missing != 0 && repeating != 0)
					break;
			}

			System.out.println(repeating + " " + missing);
		}
		scan.close();
	}

}
