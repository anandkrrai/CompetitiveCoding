package dp;

public class mines {
	public boolean isPowerOfFour(int x) {
		if (x == -2147483648)
			return false;
		return (x != 0 && ((x & (x - 1)) == 0)) && (((x / 2) & ((x / 2) - 1)) == 0);
	}

	public static boolean isValid(int i, int j, int[][] arr) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
			return false;
		} else if (arr[i][j] == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static int count_steps(int i, int j, int[][] arr) {
		int steps = 0;
		int[] x = { i, i, i, i };
		int[] y = { j, j, j, j };

		while (true) {
			boolean bool = true;
			for (int k = 0; k < 4; ++k) {
				bool = bool && isValid(x[k], y[k], arr);
				if (!bool)
					return steps;
			}
			++steps;
			// up
			x[0] += -1;
			// down
			x[1] += 1;
			// right
			y[2] += -1;
			// left
			y[3] += 1;
		}
		// return steps;
	}

	public static int orderOfLargestPlusSign(int N, int[][] mines) {
		int rv = 0;
		for (int i = 0; i < mines.length; ++i) {
			for (int j = 0; j < mines[0].length; ++j) {
				rv = Math.max(rv, count_steps(i, j, mines));
			}
		}
		return rv;
	}

	public static void main(String[] args) {
		int n = 64;
		System.out.println(n & (n - 1));
	}

}
