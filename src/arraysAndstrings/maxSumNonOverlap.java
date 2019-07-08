package arraysAndstrings;

public class maxSumNonOverlap {
	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int[] arr = new int[A.length + 1];
		arr[0] = 0;

		for (int i = 1; i <= A.length; ++i) {
			arr[i] = arr[i - 1] + A[i - 1];
		}

		int max = 0;
		for (int i = 0; i <= A.length - L; ++i) {
			int ls = i, le = i + L - 1, ms = 0, me = M - 1;

			while (me != A.length) {

				if (me < ls || ms > le) {
					max = Math.max(max, arr[le + 1] - arr[ls] + arr[me + 1] - arr[ms]);
				}
				++me;
				++ms;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12 };
		int l = 5, m = 4;
		System.out.println(maxSumTwoNoOverlap(arr, l, m));
	}

}
