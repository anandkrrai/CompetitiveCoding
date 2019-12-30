package dp;

public class MaxProductSlice {

	public static int MaxCutProd(int n) {
		int[] arr = new int[n + 1];
		calc(n, arr);
		int ans = arr[n];
		return ans;
	}

	public static int calc(int n, int arr[]) {
		if (n <= 1) {
			arr[n] = n;
			return n;
		}
		if (arr[n] != 0)
			return arr[n];

		int rv = 0;

		for (int i = 1, j = n - 1; i <= j; ++i, --j) {
			rv = Math.max(rv, calc(j, arr) * calc(i, arr) * i * j);
		}

		arr[n] = rv;
		return arr[n];

	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; ++i)
			System.out.println("for length " + i + "=" + MaxCutProd(i));
	}

}
