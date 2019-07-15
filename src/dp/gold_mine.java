package java_ada;

public class gold_mine {

	public static void main(String[] args) {

		int[][] a = { { 4, 5, 7, 3, 5 }, { 6, 7, 2, 0, 2 }, { 3, 0, 5, 4, 6 }, { 2, 4, 3, 0, 3 }, { 5, 7, 6, 4, 2 } };
		int[][] strg = gold(a);

		int max = strg[0][0];
		for (int i = 1; i < strg.length; i++) {
			max = Math.max(max, strg[i][0]);
		}
		for (int i = 1; i < strg.length; i++) {
			if (max == strg[i][0]) {
				printgold(strg, i + "", i, 0);
			}
		}

	}

	private static void printgold(int[][] strg, String psf, int i, int j) {
		if (j == strg.length - 1) {
			System.out.println(psf);
		} else if (i == 0) {
			int max = Math.max(strg[i][j + 1], strg[i + 1][j + 1]);

			if (strg[i][j + 1] == max) {

			}
			if (strg[i + 1][j + 1] == max) {

			}
		} else if (i == strg.length - 1) {
			int max = Math.max(strg[i][j + 1], strg[i - 1][j + 1]);
			if (strg[i][j + 1] == max) {

			}
			if (strg[i - 1][j + 1] == max) {

			}
		} else {
			int max = Math.max(strg[i][j + 1], Math.max(strg[i + 1][j + 1], strg[i - 1][j + 1]));
			if (strg[i][j + 1] == max) {

			}
			if (strg[i - 1][j + 1] == max) {

			}
			if (strg[i + 1][j + 1] == max) {

			}
		}

	}

	private static int[][] gold(int[][] a) {
		int[][] b = new int[a.length][a.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j >= 0; j--) {
				if (j == a.length - 1) {
					b[i][a.length - 1] = a[i][a.length - 1];
				} else if (i == 0) {
					b[i][j] = Math.max(b[i][j + 1], b[i + 1][j + 1]) + a[i][j];
				} else if (i == a.length - 1) {
					b[i][j] = Math.max(b[i][j + 1], b[i - 1][j + 1]) + a[i][j];
				} else {
					b[i][j] = Math.max(b[i][j + 1], Math.max(b[i + 1][j + 1], b[i - 1][j + 1])) + a[i][j];
				}

			}

		}

		return b;
	}
}
