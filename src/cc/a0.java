package cc;

public class a0 {

	public static int partition(int[] arr, int lo, int hi) {
		int i = lo - 1;
		int pivoit = arr[hi];

		for (int j = lo; j < hi; ++j) {
			if (arr[j] <= pivoit) {
				++i;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		++i;
		int temp = arr[i];
		arr[i] = arr[hi];
		arr[hi] = temp;

		return i;
	}

	public static void pivoitSort(int[] arr, int lo, int hi) {
		if (hi < lo) {
			return;
		}
		int pivoit = partition(arr, lo, hi);
		pivoitSort(arr, lo, pivoit - 1);
		pivoitSort(arr, pivoit + 1, hi);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 2, 6, 3, 6, 3, 3, 2, 1, 23, 5 };

		for (int x : arr) {
			System.out.print(x + " ");
		}

		System.out.println();
//		pivoitSort(arr, arr.length - 1, 0);
		pivoitSort(arr, 0, arr.length - 1);

		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

}
