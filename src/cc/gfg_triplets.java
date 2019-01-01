package cc;

import java.util.Scanner;

public class gfg_triplets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			if (findTriplets(a, n))
				System.out.println("1");
			else
				System.out.println("0");

		}
		sc.close();
	}

	public static boolean findTriplets(int arr[], int n) {

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length; ++j) {
				for (int k = 0; k < arr.length; ++k) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
