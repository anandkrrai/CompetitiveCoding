package cc;

public class exitPoint {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		int[][] arr1 = { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11 }, { 12, 13, 14, 15 } };

		findPath(arr);

		print(arr1);
		transpose(arr1);
		swap(arr1);
		print(arr1);
	}

	private static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void transpose(int[][] arr) {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = i; j < arr.length; ++j) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

	}

	private static void swap(int[][] arr) {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length / 2; ++j) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][-j + arr.length - 1];
				arr[i][-j + arr.length - 1] = temp;

			}
		}
	}

	private static void findPath(int[][] arr) {
		int[] yi = { 1, 0, -1, 0 };
		int[] xi = { 0, 1, 0, -1 };
		int x = 0, y = 0, x1 = 0, y1 = 0;
		while (true) {

			if (arr[x][y] == 1) {
				y1 = (y1 + 1) % 4;
				x1 = (x1 + 1) % 4;
			}

			if (x + xi[x1] > arr.length || x + xi[x1] < 0 || y + yi[y1] < 0 || y + yi[y1] >= arr[0].length) {
				System.out.println("x:" + x + " y:" + y);

				break;
			}

			x += xi[x1];
			y += yi[y1];

		}

	}

}
