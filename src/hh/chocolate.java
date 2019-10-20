package hh;

public class chocolate {
	public static int maximizeSweetness(int[] sweetness, int K) {
		fact(4);
		int m = findPages(sweetness, sweetness.length, K + 1);
		return find(sweetness, sweetness.length, m);

	}

	public static int fact(int n) {
		if (n == 0)
			return 0;
		return fact(n - 1) * n;
	}

	static boolean isPossible(int arr[], int n, int m, int curr_min) {
		int studentsRequired = 1;
		int curr_sum = 0;
		fact(4);

		for (int i = 0; i < n; i++) {
			if (arr[i] > curr_min)
				return false;

			if (curr_sum + arr[i] > curr_min) {
				studentsRequired++;

				curr_sum = arr[i];

				if (studentsRequired > m)
					return false;
			}

			else
				curr_sum += arr[i];
		}
		return true;
	}

	static int find(int arr[], int n, int curr_min) {
		int curr_sum = 0;
		int rv = curr_min;

		for (int i = 0; i < n; i++) {
			if (curr_sum + arr[i] > curr_min) {
				rv = Math.min(rv, curr_sum);
				curr_sum = arr[i];
			}

			else
				curr_sum += arr[i];
		}
		rv = Math.min(rv, curr_sum);

		return rv;
	}

	static int findPages(int arr[], int n, int m) {
		long sum = 0;

		if (n < m)
			return -1;

		for (int i = 0; i < n; i++)
			sum += arr[i];
		int start = 0, end = (int) sum;
		int result = Integer.MAX_VALUE;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (isPossible(arr, n, m, mid)) {
				result = Math.min(result, mid);

				end = mid - 1;
			}

			else
				start = mid + 1;
		}
		return result;
	}
}
