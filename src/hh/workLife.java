//package hh;

import java.util.Scanner;

public class workLife {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			int max = 0, sum = 0;
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
				max = Math.max(max, arr[i]);
				sum += arr[i];
			}
			if (arr[n - 1] == max) {
				System.out.println(max);
				continue;
			} else {
				System.out.println(sum / n);
			}
		}
	}

}
