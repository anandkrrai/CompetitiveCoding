package cc;

import java.util.Arrays;
import java.util.Scanner;

//https://www.codechef.com/JAN18/problems/MAXSC/

public class codecfef_maxsc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < arr.length; ++i) {
				for (int j = 0; j < arr[0].length; ++j) {
					arr[i][j]=scan.nextInt();
				}
			}
			
			for (int i = 0; i < n; ++i) {
				Arrays.sort(arr[i]);
			}
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				sum += arr[i][n - 1];
			}
			System.out.println(sum);

		}
		scan.close();
	}

}
