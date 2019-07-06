package arraysAndstrings;

public class spartialMatricx {

	public static int[][] generateMatrix(int n) {
		int[][] arr = new int[n][n];
		int ru = 0, rl = n - 1, cl = 0, cr = n - 1, count = 1;

		while (count <= n*n) {
			for (int i = cl; i <= cr; ++i) {
				arr[ru][i] = count;
				++count;
			}
			++ru;

			for (int i = ru; i <= rl; ++i) {
				arr[i][cr] = count;
				++count;
			}
			--cr;

			for (int i = cr; i >= cl; --i) {
				arr[rl][i] = count;
				++count;
			}
			--rl;

			for (int i = rl; i >= ru; --i) {
				arr[i][cl] = count;
				++count;
			}
			++cl;

		}

		return arr;
	}

	public static void main(String[] args) {
		int[][] arr = generateMatrix(4);
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr.length;++j)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

}
