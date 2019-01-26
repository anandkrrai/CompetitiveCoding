package cc;

public class gfg_islandscount {
	

	public static int findisland(int[][] arr, int n, int m) {
		int rv = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (arr[i][j] == 1) {
					makeOne(arr, i, j);
					arr[i][j] = 1;
//					++rv;
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (arr[i][j] == 1) {
					++rv;
				}
			}
		}

		return rv;
	}

	private static void makeOne(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
			return;
		}
		if (arr[i][j] != 1) {
			return;
		}
		arr[i][j] = 0;
		makeOne(arr, i, j + 1);
		makeOne(arr, i + 1, j + 1);
		makeOne(arr, i + 1, j);
		makeOne(arr, i + 1, j - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
