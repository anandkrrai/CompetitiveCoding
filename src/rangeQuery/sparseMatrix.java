package rangeQuery;
public class sparseMatrix {

	static int[] log;
	static int[][] sparse;

	public static int getlog(int n) {
		int count = 0;

		while (1 << count <= n) {
			++count;
		}

		return count - 1;
	}

	public static void build(int[] arr) {
		log = new int[arr.length + 1];

		for (int i = 0; i < log.length; ++i) {
			log[i] = getlog(i);
		}

		int row = arr.length, col = log[arr.length] + 1;
		sparse = new int[row][col];

		for (int j = 0; j < col; ++j) {
			for (int i = 0; i < row; ++i) {
				if (j == 0) {
					sparse[i][j] = arr[i];
				} else {
					if (i + (1 << (j - 1)) < row)
						sparse[i][j] = Math.min(sparse[i][j - 1], sparse[i + (1 << (j - 1))][j - 1]);
				}
			}
		}

	}

	public static int query(int l, int r) {
		int n = r - l + 1;
		int lo = log[n];
		int segment = 1 << lo;

		return Math.min(sparse[l][lo], sparse[r - segment + 1][lo]);
	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, -1, 6, 8, -4, 7, 12, 5, 4, -9, 3, 20, -16, 4, 11 };
		build(arr);
		System.out.println(query(10, 15));
		System.out.println(query(6, 12));
		System.out.println(query(2, 5));

	}

}
