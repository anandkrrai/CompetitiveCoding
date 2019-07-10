package arraysAndstrings;

import java.util.Arrays;

public class mazePath {
	public static int path(int cc, int cr, int ec, int er, int[][] arr) {
		if (cc > ec || cr > er) {
			return 0;
		}
		if (cc == ec && cr == er)
			return 1;
		if (arr[cr][cc] != 0)
			return arr[cr][cc];

		int ch = path(cc + 1, cr, ec, er, arr);
		int cv = path(cc, cr + 1, ec, er, arr);
		int count = ch + cv;
		arr[cr][cc] = count;
		return count;
	}

	public static int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];

		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (i == m - 1 && j == n - 1) {
					arr[i][j] = 1;
				} else if (i == m - 1) {
					arr[i][j] = arr[i][j + 1];
				} else if (j == n - 1) {
					arr[i][j] = arr[i + 1][j];
				} else {
					arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
				}
			}
		}
		return arr[0][0];
	}

	public static int uniquePathsFast(int m, int n) {
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		for (int i = 1; i < m; ++i) {
			for (int j = n - 2; j >= 0; --j) {
				arr[j] += arr[j + 1];
			}
		}
		return arr[0];
	}

	public static void main(String[] args) {
		int ec = 25, er = 5;
		int[][] arr = new int[er][er];
//		System.out.println(path(0, 0, ec-1, er-1, arr));
		System.out.println(uniquePaths(er, ec));
		System.out.println(uniquePathsFast(er, ec));
	}

}
