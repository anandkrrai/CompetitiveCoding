package hh;

public class fibboMatrixExponentiation {

	public static int power(int n, int x) {
		if (x == 1)
			return n;

		int rv = power(n, x / 2);

		if (x % 2 == 0)
			return rv * rv;
		else
			return rv * rv * n;
	}

	public static int[][] powerMatrix(int[][] arr, int x) {
		if (x == 1) {
			return arr;
		}

		int[][] rv = powerMatrix(arr, x / 2);

		if (x % 2 == 0) {
			return mul(rv, rv);
		} else {
			return mul(mul(rv, rv), arr);
		}
	}

	private static int[][] mul(int[][] arr1, int[][] arr2) {
		int[][] rv = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; ++i) {
			for (int j = 0; j < arr2.length; ++j) {
				for (int k = 0; k < arr1[0].length; ++k) {
					rv[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return rv;
	}

	public static int fibbo(int n) {
		int[][] multiplyer = { { 1, 1 }, { 1, 0 } };
		int[][] base = { { 1, 0 }, { 0, 0 } };

		int[][] rv = mul(powerMatrix(multiplyer, n), base);

		return rv[1][0];

	}

	public static int fibbo1(int n) {
		int[][] multiplyer = { { 1, 1 }, { 1, 0 } };
		int[][] base = { { 1, 0 }, { 0, 0 } };

		int[][] rv = mul(base, powerMatrix(multiplyer, n));

		return rv[0][1];
	}

	public static void main(String[] args) {
//		System.out.println(power(2, 6));
//		int[][] multiplyer = { { 1, 1 }, { 1, 0 } };
//		int[][] base = { { 1, 0 }, { 0, 0 } };
//		int[][] ar = mul( multiplyer,base);
		System.out.println(fibbo1(10));

	}

}
