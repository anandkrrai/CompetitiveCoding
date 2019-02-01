package cc;

import java.util.Scanner;

public class codechef_magicalJars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) {
				a[i] = scan.nextInt();
			}
			int max = 0;
			for (int temp : a) {
				max = Math.max(max, temp);
			}

			System.out.println(max);
		}

		scan.close();
	}

}
