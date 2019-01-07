package cc;

import java.util.Scanner;

public class hackerEarth_large_sub_arrays {
	public static long num_in_array(int[] arr, long k) {
		long rv = 0;
		for (int i = 0; i < arr.length; ++i) {
			long sum = arr[i];
			int j = i;
			while (sum <= k) {
				++rv;
				++j;
				if(j>=arr.length)
					break;
				sum += arr[j];
				
			}
		}

		return rv;
	}

	public static long num_in_array(int[] arr, long k, int m) {
		long rv = 0;
		for (int i = 0; i < arr.length * m; ++i) {
			long sum = arr[i % arr.length];
			int j = i + 1;
			while (sum <= k && j < arr.length * m) {
				++rv;
				sum += arr[j % arr.length];
				++j;
			}
		}

		return rv;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long mod = 1000000007;
		long k;
		int n, m;
		int t = s.nextInt();
		s.nextLine();
		while (t-- > 0) {
			n = s.nextInt();
			m = s.nextInt();
			k = s.nextLong();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; ++i) {
				arr[i] = s.nextInt();
			}
			long single = num_in_array(arr, k) % mod;
//			System.out.println(single);

			int[] arr2 = new int[2 * n];
			for (int i = 0; i < arr2.length; ++i) {
				arr2[i] = arr[i % arr.length];
			}

			long multiple = num_in_array(arr2, k);
//			System.out.println(multiple);

			long olc = multiple - 2 * single;
//			System.out.println(olc);
			long ans;
			if (m >= 2)
				ans = (single * m + (m - 1) * olc) % mod;
			else {
				ans = multiple;
			}
			System.out.println(ans);

//			System.out.println(num_in_array(arr, k, m) % mod);
		}

	}

}
