package cc;

public class islands {

	public static void main(String[] args) {

		int[][] arr = 
				{{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

//		System.out.println(maxAreaOfIsland(arr));
		
		System.out.println(countNumber(arr));

	}

	public static int countNumber(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				if (arr[i][j] == 1) {
					++count;
					funCall(arr, i, j);
				}
			}
		}
		return count;
	}

	public static void funCall(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] != 1) {
			return;
		}
		arr[i][j] = 0;
		funCall(arr, i, j + 1);
		funCall(arr, i, j - 1);
		funCall(arr, i + 1, j);
		funCall(arr, i - 1, j);
	}

	public static int find(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] != 1) {
			return 0;
		}

		int ans = 1;
		arr[i][j] = -1;

		ans += find(arr, i, j + 1);
		ans += find(arr, i, j - 1);
		ans += find(arr, i + 1, j);
		ans += find(arr, i - 1, j);

		return ans;
	}

	public static int maxAreaOfIsland(int[][] grid) {

		int max = 0;

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == 1) {
					max = Math.max(max, find(grid, i, j));
				}
			}
		}

		return max;
	}

}
