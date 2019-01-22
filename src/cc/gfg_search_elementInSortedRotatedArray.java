package cc;

public class gfg_search_elementInSortedRotatedArray {

	public static int binarySearch(int[] arr, int search, int lo, int hi) {
		int rv = -1;

		int mid = (lo + hi) / 2;

		while (lo <= hi) {
			mid = (lo + hi) / 2;

			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] < search) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return rv;
	}

	public static int binarySearch(int[] arr, int search) {
		int rv = -1;

		int lo = 0, hi = arr.length - 1, mid = (lo + hi) / 2;

		while (lo <= hi) {
			mid = (lo + hi) / 2;

			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] < search) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return rv;
	}

	public static int binaryRotatedSearch(int[] arr, int search, int pivot) {
		int rv = -1, m = arr.length - 1;

		int lo = pivot % m, hi = (arr.length - 1 + pivot) % m, mid;

		while (lo <= hi) {
			mid = (lo + hi) / 2;

			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] < search) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return rv;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };

		int piviot = arr.length - 1;
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] > arr[i + 1]) {
				piviot = i + 1;
				break;
			}
		}
		System.out.println(binarySearch(arr, 8, 0, piviot));
//		System.out.println(binaryRotatedSearch(arr, 1, piviot));

	}

}
