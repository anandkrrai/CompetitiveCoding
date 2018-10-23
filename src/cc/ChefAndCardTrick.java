package cc;

import java.util.Scanner;

public class ChefAndCardTrick {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;

			int n = scan.nextInt();

			int arr[] = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}

			boolean flag = false;

			for (int i = 0; i < n; ++i) {
				int j;
				for (j = i; j <= i + n; ++j) {
					if (arr[j % n] >= arr[(j + 1) % n]) {
						break;
					}
				}

				if (j == i + n - 1) {
					flag = true;
					break;
				}

			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

}
//int count = 0;
//for (int i = 1; i < n - 1; ++i) {
//
//	if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
//		++count;
//	}
//	if (count == 2) {
//		break;
//	}
//}
//if (count < 2) {
//	System.out.println("YES");
//} else {
//	System.out.println("NO");
//}