package cc;

import java.util.Arrays;
import java.util.Scanner;

public class preElemination {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int k = scan.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();

			}

			Arrays.sort(arr);

			for (int i = 0; i < n / 2; ++i) {
				int temp = arr[i];
				arr[i] = arr[n - i - 1];
				arr[n - i - 1] = temp;
			}

			int num_teams = k;
			int curr, prev = arr[k - 1];

			for (int i = k; i < n; ++i) {
				curr = arr[i];
				if (prev != curr) {
					break;
				}
				++num_teams;
			}

			System.out.println(num_teams);

		}

		scan.close();
	}

}
