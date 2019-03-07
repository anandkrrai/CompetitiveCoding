package cc;

import java.util.Scanner;

public class cf_strangecompetition {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
//			int[] arr = new int[n];

			int small = 0, large = 0, temp;

			for (int i = 0; i < n; ++i) {
				temp = scan.nextInt();
				if (temp >= 0) {
					++large;
				} else {
					++small;
				}
			}

			if (small == 0) {
				System.out.println(large + " " + large);
			} else {
				System.out.println(large + " " + small);
			}
		}
	}

}
