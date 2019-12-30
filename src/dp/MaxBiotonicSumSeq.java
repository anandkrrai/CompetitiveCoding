package dp;

public class MaxBiotonicSumSeq {

	public static int MaxBiotonicSum(int[] arr) {
		int[] left = new int[arr.length], right = new int[arr.length];

		for (int i = 0; i < arr.length; ++i) {
			left[i] = arr[i];
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i]) {
					left[i] = Math.max(left[i], left[j] + arr[i]);
				}
			}
		}

		for (int i = arr.length - 1; i >= 0; --i) {
			right[i] = arr[i];
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[i] > arr[j]) {
					right[i] = Math.max(right[i], right[j] + arr[i]);
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < arr.length; ++i) {
			sum = Math.max(left[i] + right[i] - arr[i], sum);
		}
		return sum;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
		System.out.println(MaxBiotonicSum(arr));
	}

}
