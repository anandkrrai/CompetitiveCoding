package arraysAndstrings;

public class subarrayWithSumInRange {
	public static void print(int[] arr, int lo, int hi) {
		for (int i = lo; i <= hi; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int numSubarrayBoundedMax(int[] arr, int lo, int hi) {
		int rv = 0, left = 0, right = 0, sum = 0, num;

		for (right = 0; right < arr.length; ++right) {
			sum += arr[right];
			if (sum >= lo && sum <= hi) {
				num = right - left + 1;
				System.out.print((num * (num + 1)) / 2+" ->");
//				rv += (num * (num + 1)) / 2;
				rv+=num;
				print(arr, left, right);
			}
			while (sum > hi) {
				sum -= arr[left];
				++left;
			}
		}
		
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 9, 2, 5,1, 9,6,1 };
		System.out.println(numSubarrayBoundedMax(arr, 2, 8));
	}
}
