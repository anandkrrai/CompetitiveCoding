
public class ExtraElement {
	static int findExtra(int arr1[], int arr2[], int n) {
// Initialize result 
		int index = n;

// left and right are end  
// points denoting the current range. 
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

// If middle element is same  
// of both arrays, it means  
// that extra element is after  
// mid so we update left to mid+1 
			if (arr2[mid] == arr1[mid])
				left = mid + 1;

// If middle element is different 
// of the arrays, it means that  
// the index we are searching for 
// is either mid, or before mid.  
// Hence we update right to mid-1. 
			else {
				index = mid;
				right = mid - 1;
			}
		}

// when right is greater than  
// left, our search is complete. 
		return index;
	}

// Driver Code 
	public static void main(String[] args) {
		int arr1[] = { 2, 4, 6, 9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
		int arr2[] = { 2, 4, 6, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
		int n = arr2.length;

// Solve is passed both arrays 
		System.out.println(findExtra(arr1, arr2, n));
	}
}
