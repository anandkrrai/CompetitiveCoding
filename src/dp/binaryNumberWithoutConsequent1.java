package dp;

public class binaryNumberWithoutConsequent1 {

	public static int calc(int n) {
		int[] zero = new int[n + 1];
		int[] one = new int[n + 1];
		zero[1] = one[1] = 1;

		for (int i = 2; i <= n; ++i) {
			zero[i] = one[i - 1] + zero[i - 1];
			one[i] = zero[i - 1];
		}

		return zero[n] + one[n];
	}

	public static int calc_ptimized(int n) {
		int zero_prev = 1, one_prev = 1, zero_curr = 1, one_curr = 1;

		for (int i = 2; i <= n; ++i) {
			zero_curr = zero_prev + one_prev;
			one_curr = zero_prev;
			zero_prev = zero_curr;
			one_prev = one_curr;
		}

		return zero_curr + one_curr;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; ++i)
			System.out.println(calc(i));

		for (int i = 1; i < 10; ++i)
			System.out.println(calc_ptimized(i));
	}

}
