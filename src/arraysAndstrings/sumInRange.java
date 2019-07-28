package arraysAndstrings;

public class sumInRange {
	static int countSub(int arr[], int n, int x) {

// Starting index of 
// sliding window. 
		int st = 0;

// Ending index of  
// sliding window. 
		int end = 0;

// Sum of elements currently  
// present in sliding window. 
		int sum = 0;

// To store required  
// number of subarrays. 
		int cnt = 0;

// Increment ending index  
// of sliding window one 
// step at a time. 
		while (end < n) {

			// Update sum of sliding
			// window on adding a
			// new element.
			sum += arr[end];

			// Increment starting index
			// of sliding window until
			// sum is greater than x.
			while (st <= end && sum > x) {
				sum -= arr[st];
				st++;
			}

			// Update count of
			// number of subarrays.
			cnt += (end - st + 1);
			end++;
		}

		return cnt;
	}

// Function to find number  
// of subarrays having sum  
// in the range L to R. 
	static int findSubSumLtoR(int arr[], int n, int L, int R) {

// Number of subarrays  
// having sum less than  
// or equal to R. 
		int Rcnt = countSub(arr, n, R);

// Number of subarrays  
// having sum less than  
// or equal to L-1. 
		int Lcnt = countSub(arr, n, L - 1);

		return Rcnt - Lcnt;
	}

// Driver code 
	public static void main(String[] args) {
		int arr[] = { -2, 5, -1 };
		int n = arr.length;

		int L = -2;
		int R = 2;

		System.out.println(findSubSumLtoR(arr, n, L, R));
	}
}
