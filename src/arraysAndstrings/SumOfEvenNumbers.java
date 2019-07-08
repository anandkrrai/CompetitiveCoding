package arraysAndstrings;

public class SumOfEvenNumbers {
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] rv = new int[queries.length];
		int sum = 0;

		for (int i = 0; i < A.length; i++) {

			if (A[i] % 2 == 0)
				sum += A[i];
		}

		for (int i = 0; i < queries.length; ++i) {
			int val = queries[i][0];
			int old = A[queries[i][1]];

			A[queries[i][1]] += val;

			if (A[queries[i][1]] % 2 == 0) {
				if (old % 2 == 0) {
					sum += val;
				} else {
					sum += A[queries[i][1]];
				}
			} else {
				if (old % 2 == 0) {
					sum -= old;
				} else {
					// do nothing
				}
			}

			rv[i] = sum;
		}
		return rv;
	}
}
