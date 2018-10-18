package cc;

import java.util.Scanner;

public class SpreadTheWord {

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
			int sum = arr[0];
			int i = 1;
			for (i = 1; i < sum; ++i) {
				if (sum >= arr.length)
					break;
				int sum1 = 0;
				for (int j = 0; j < i; ++j) {
					sum1 += arr[j];
				}
				sum += sum1;
			}

			System.out.println(i);

		}
		scan.close();

	}

}
