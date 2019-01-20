package cc;

import java.util.*;

public class codechef_maxdiff {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = s.nextInt();
			}

			Arrays.sort(arr);

			for (int i = 1; i < arr.length; ++i) {
				arr[i] += arr[i - 1];
			}

			System.out.println(Math.max(arr[n - 1] - 2 * arr[k - 1], arr[n - 1] - 2 * arr[n - 1 - k]));
		}

		s.close();

	}

}
