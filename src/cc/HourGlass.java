package cc;

import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; ++i) {
			for (int j = 0; j < 6; ++j) {
				arr[i][j] = scan.nextInt();
			}
		}

		int max = Integer.MIN_VALUE, sum = 0, i1 = 1, j1 = 1;

		for (int i = 1; i < 5; ++i) {
			for (int j = 1; j < 5; ++j) {
				sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i][j] + arr[i + 1][j - 1]
						+ arr[i + 1][j] + arr[i + 1][j + 1];
				if (sum > max) {
					max = sum;
//					i1 = i;
//					j1 = j;
				}
			}
		}

		System.out.println(max);
//		System.out.println(arr[i1 - 1][j1 - 1] + " " + arr[i1 - 1][j1] + " " + arr[i1 - 1][j1 + 1] + "\n  "
//				+ arr[i1][j1] + "\n" + arr[i1 + 1][j1 - 1] + " " + arr[i1 + 1][j1] + " " + arr[i1 + 1][j1 + 1]);

		scan.close();
	}

}
