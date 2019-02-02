package cc;

import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		while (t-- > 0) {
			scan.nextLine();
			String st = scan.nextLine();
			String[] str = st.trim().split("\\s+");
			System.out.println(lcsLength(str));

		}
		scan.close();
	}

	private static int lcsLength(String[] str) {
		int n = str[2].length(), m = str[1].length(), l = str[0].length();
		int[][][] arr = new int[l + 1][m + 1][n + 1];

		for (int i = 0; i <= l; ++i) {
			for (int j = 0; j <= m; ++j) {
				for (int k = 0; k <= n; ++k) {
					if (i == 0 || j == 0 || k == 0) {
						arr[i][j][k] = 0;
					} else if (str[0].charAt(i - 1) == str[1].charAt(j - 1)
							&& str[0].charAt(i - 1) == str[2].charAt(k - 1)) {
						arr[i][j][k] = 1 + arr[i - 1][j - 1][k - 1];
					} else {
						arr[i][j][k] = Math.max(Math.max(arr[i - 1][j][k], arr[i][j - 1][k]), arr[i][j][k - 1]);
					}
				}
			}
		}

		return arr[l][m][n];
	}

	private static int lcsLength(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		int[][] arr = new int[n + 1][m + 1];

		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					arr[i][j] = 1 + arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}

		return (arr[n][m]);
	}

}
