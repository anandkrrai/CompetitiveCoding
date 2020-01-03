package dp;

public class MaxSumKConcatenationOfArray {
	public static int Kadane(int[] arr) {
		int sum = 0, temp = 0;
		for (int i = 0; i < arr.length; ++i) {
			temp += arr[i];
			sum = Math.max(sum, temp);
			if (temp < 0) {
				temp = 0;
			}
		}
		return sum;
	}

	public static int kConcatenationMaxSum(int[] arr, int k) {
		int[] arr2 = new int[2 * arr.length];

		if (arr.length == 0 || k == 0)
			return 0;

		if (k == 1)
			return Kadane(arr);

		for (int i = 0; i < arr2.length; ++i) {
			arr2[i] = arr[i % arr.length];
		}

		int kadane_arr2 = Kadane(arr2), sum = 0, sumLeft = 0, sumRight = 0, temp = 0;

		for (int val : arr) {
			sum += val;
			sumLeft = Math.max(sumLeft, sum);
		}

		for (int i = arr.length - 1; i >= 0; --i) {
			temp += arr[i];
			sumRight = Math.max(sumRight, temp);
		}
		int sumSide = Math.max(sumLeft, sumRight);

		if (sum < 0)
			return kadane_arr2;
		else
			return Math.max(sum, sumSide) + sum * (k - 1);
	}

	static void arrayConcatenate(int arr[], int b[], int k) {
// Array b will be formed by concatenation 
// array a exactly k times 
		int j = 0;
		while (k > 0) {

			for (int i = 0; i < arr.length; i++) {
				b[j++] = arr[i];
			}
			k--;
		}
	}

// Function to return the maximum  
// subarray sum of arr[] 
	static int maxSubArrSum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

// Function to return the maximum sub-array  
// sum of the modified array 
	static long maxSubKSum(int arr[], int k) {
		int arrSum = 0;
		long maxSubArrSum = 0;

		int b[] = new int[(2 * arr.length)];

// Concatenating the array 2 times 
		arrayConcatenate(arr, b, 2);

// Finding the sum of the array 
		for (int i = 0; i < arr.length; i++)
			arrSum += arr[i];

// If sum is less than zero 
		if (arrSum < 0)
			maxSubArrSum = maxSubArrSum(b);

// If sum is greater than zero 
		else
			maxSubArrSum = maxSubArrSum(b) + (k - 2) * arrSum;

		return maxSubArrSum;
	}

	static int maxSubArraySumRepeated(int a[], int n, int k) {
		int max_so_far = 0;
		int INT_MIN, max_ending_here = 0;

		for (int i = 0; i < n * k; i++) {
// This is where it differs from  
// Kadane's algorithm. We use modular 
//  arithmetic to find next element. 
			max_ending_here = max_ending_here + a[i % n];

			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;

			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		int[] arr = { -5, -2, 0, 0, 3, 9, -2, -5, 4 };
		int k = 5;
		System.out.println(maxSubKSum(arr, k));
		System.out.println(kConcatenationMaxSum(arr, k));
		System.out.println(maxSubArraySumRepeated(arr, arr.length, k));

	}

}
