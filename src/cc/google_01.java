package cc;

import java.util.Scanner;

public class google_01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();

		while (t > 0) {
			--t;

			int n = scanner.nextInt();
			int sum = scanner.nextInt();
			int temp;
			boolean found = false;
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scanner.nextInt();
			}

			for (int i = 1; i < arr.length; ++i) {
				arr[i] += arr[i - 1];
				if (arr[i] == sum) {
					++i;
					System.out.println("1 " + i);
					found = true;
					--i;
				}
			}

			for (int i = 0; i < arr.length; ++i) {
				for (int j = 0; j <= i; ++j) {
					temp = arr[i] - arr[j];
					if (temp == sum) {
						++i;
						System.out.println(j + 2 + " " + i);
						--i;
						found = true;
						break;
					} else if (temp < sum) {
						break;
					}
				}
				if (found)
					break;
			}
			if (!found) {
				System.out.println("-1");
			}
		}
		scanner.close();
	}

}
