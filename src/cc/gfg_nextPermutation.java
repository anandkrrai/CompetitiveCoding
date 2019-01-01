package cc;

import java.util.Arrays;
import java.util.Scanner;

public class gfg_nextPermutation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//		int t = scanner.nextInt();
		int t = 1;
//		scanner.nextLine();

		while (t-- > 0) {
//			int n = scanner.nextInt();
//
//			int[] arr = new int[n];
//
//			for (int i = 0; i < n; ++i) {
//				arr[i] = scanner.nextInt();
//			}

			int[] arr = { 1, 5, 0, 5, 4, 2 };
			findNextPattern(arr);

		}

		scanner.close();
	}

	private static void findNextPattern(int[] arr) {
		int curr, i, prev = arr[arr.length - 1];
		for (i = arr.length - 2; i >= 0; --i) {
			curr = arr[i];
			if (prev < curr) {
				break;
			}
		}

		Arrays.sort(arr, i, arr.length);
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;

		for (int j = 0; j < arr.length; ++j) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();

	}

}
