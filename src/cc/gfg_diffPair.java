package cc;

import java.util.Arrays;
import java.util.Scanner;

public class gfg_diffPair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			int n = sc.nextInt();
			int diff = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			int l = 0, r = n - 1, temp;
			boolean flag = false;
			while (l <= r) {
				temp = arr[r] - arr[l];
				if (diff == temp) {
					flag = true;
					break;
				} else if (temp > diff) {
					--r;
				} else {
					++l;
				}
			}

			if (flag) {
				System.out.println("1");
			} else {
				System.out.println("-1");
			}
		}
	}

}
