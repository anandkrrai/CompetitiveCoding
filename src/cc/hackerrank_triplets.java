package cc;

import java.util.Arrays;

public class hackerrank_triplets {

	static long triplets(int[] a, int[] b, int[] c) {
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);

		long ans = 0;
		int j, k;

		for (int i = 0; i < b.length; ++i) {

			for (j = 0; j < a.length && a[j] <= b[i]; ++j) {

			}
			for (k = 0; k < c.length && c[k] <= b[i]; ++k) {

			}

			ans += j * k;
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 1, 4, 5 };
		int[] b = { 2, 3, 3 };
		int[] c = { 1, 2, 3 };

		int[] arr = { 3, 4, 8, 2, 5, 1 ,3};

		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();

		arr=Arrays.stream(arr).sorted().distinct().toArray();

		for (int x : arr) {
			System.out.print(x + " ");
		}

//		System.out.println(triplets(a, b, c));

	}

}
