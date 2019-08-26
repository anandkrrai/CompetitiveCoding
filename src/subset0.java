import java.util.Arrays;

public class subset0 {

	long helper(long n) {
		if (n <= 1) {
			return 0;
		}

		long res = 0;

		if (n % 2 == 0) {
			res += 2;
		}
		while (n % 2 == 0) {
			n /= 2;
		}

		long div = 3;

		while (n != 1) {
			if (n % div == 0) {
				res = (res % 1000000) + (div % 1000000);
				while (n % div == 0) {
					n /= div;
				}
			}

			div += 2;
		}

		return res;

	}

	long get_res(long n, long r) {
		long res = 1;

		for (long i = 0; i < r; i++) {
			res = (res % 1000000007) * ((n - i) % 1000000007);
		}

		for (long i = 1; i <= r; i++) {
			res = (res % 1000000007) / (i % 1000000007);
		}

		return res;

	}

	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 7, 9, 3, 6, 2, 7 };

		Arrays.sort(arr);
	}

}
