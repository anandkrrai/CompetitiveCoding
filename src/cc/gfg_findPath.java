package cc;

import java.util.*;

class gfg_findPath {
	public static boolean pathExist(int[][] arr) {

		boolean rv = false;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				if (arr[i][j] == 1) {
					rv = helper(arr, i, j);
					return rv;
				}
			}
		}
		return rv;
	}

	public static boolean helper(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
			return false;
		}

		if (arr[i][j] == 2) {
			return true;
		}

		if (arr[i][j] == 1 || arr[i][j] == 3) {
			arr[i][j] = -1;

			boolean rv1 = helper(arr, i, j + 1);
			boolean rv2 = helper(arr, i, j - 1);
			boolean rv3 = helper(arr, i - 1, j );
			boolean rv4 = helper(arr, i +1, j );

			return rv1 || rv2 || rv3 || rv4;
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		HashMap<String, Boolean> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>(map.keySet());
		
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					arr[i][j] = scan.nextInt();
				}
			}
			boolean flag = pathExist(arr);

			if (flag) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
		scan.close();
	}
}