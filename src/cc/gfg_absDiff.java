package cc;

import java.util.HashMap;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/find-pair-given-difference/0

public class gfg_absDiff {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int d = scan.nextInt();
			int[] arr = new int[n];
			boolean flag = false;
			HashMap<Integer, Boolean> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
				map.put(arr[i], true);
			}

			for (int i = 0; i < n; ++i) {
				if (map.containsKey(Math.abs(d + arr[i]))) {
					flag = true;
				}
			}

			if (flag) {
				System.out.println("1");
			} else {
				System.out.println(-1);
			}
		}

		scan.close();
	}

}
