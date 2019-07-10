package dp;

public class ArithmeticSlices1 {
	public int numberOfArithmeticSlices(int[] A) {
		if (A.length <= 2)
			return 0;

		int[] count = new int[A.length];
		count[1] = 1;
		int ans = 0;
		for (int i = 2; i < A.length; ++i) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count[i] = 1 + count[i - 1];
				ans += count[i - 1];
			} else {
				count[i] = 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
