package SegTree;

public class AreaOfRectangle {
	public int mod = 1000000007;

	public int rectangleArea(int[][] rectangles) {
		boolean[][] arr = new boolean[201][201];

		for (int[] rectangle : rectangles) {
			makeRectangle(arr, rectangle);
		}

		long ans = 0;
		for (boolean[] ar : arr) {
			for (boolean b : ar) {
				if (b)
					++ans;
			}
		}
		return (int) (ans % mod);
	}

	private void makeRectangle(boolean[][] arr, int[] rectangle) {
		int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];

		for (int i = x1; i <= x2; ++i) {
			for (int j = y1; j <= y2; ++j) {
				arr[i][j] = true;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
