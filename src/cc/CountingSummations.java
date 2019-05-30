package cc;

import java.util.Scanner;

public class CountingSummations {

	public static void fillArray(int[] arr) {
		int mod = 1000000007;
		arr[0] = 1;
		for (int i = 1; i < arr.length; ++i) {
			for (int j = i; j < arr.length; ++j) {
				arr[j] = (arr[j] % mod + arr[j - i] % mod) % mod;
			}

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[] arr = new int[1002];
		fillArray(arr);

		while (t-- > 0) {
			int n = scan.nextInt();
			System.out.println(arr[n] - 1);
		}

		scan.close();
	}

}
