package dp;

public class KPalindrome {

	public static int kPalin(String str) {
		int[][] arr = new int[str.length()][str.length()];

		for (int gap = 0; gap < arr.length; ++gap) {
			for (int i = 0, j = i + gap; j < arr.length; ++i, ++j) {
				if (gap == 0) {
					arr[i][j] = 0;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						arr[i][j] = arr[i + 1][j - 1];
					} else {
						arr[i][j] = 1 + Math.min(arr[i][j - 1], arr[i + 1][j]);
					}
				}
			}
		}
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

		return arr[0][arr.length - 1];
	}

	public static void main(String[] args) {
//		String str = "abbbca";
		String str = "abcdeca";

		System.out.println(kPalin(str));
	}

}
