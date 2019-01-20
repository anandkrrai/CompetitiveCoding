package cc;

import java.util.Arrays;
import java.util.Scanner;

public class codechef_chopsticks {

	public static void main(String[] args) throws java.lang.Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int ans = 0;

		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i + 1] - arr[i] <= d) {
				++ans;
				++i;
			}
		}

		System.out.println(ans);
		sc.close();

	}
}
