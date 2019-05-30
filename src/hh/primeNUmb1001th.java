package hh;

import java.util.Scanner;

public class primeNUmb1001th {

	public static void sieve(boolean[] arr) {
		arr[0] = arr[1] = true;
		for (int i = 2; i < arr.length; ++i) {
			if (arr[i] == true)
				continue;

			for (int j = 2; j * i < arr.length; ++j) {
				arr[i * j] = true;
			}
		}
	}

	public static void main(String[] args) {
		int[] numAr = new int[10001];
		boolean[] arr = new boolean[100000000];
		sieve(arr);
		int k = 0;
		for (int i = 0; i < arr.length && k < numAr.length; ++i) {
			if (!arr[i]) {
				numAr[k++] = i;
			}
		}
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			System.out.println(numAr[n - 1]);
		}

	}

}
