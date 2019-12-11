
public class Sort012 {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void sort012(int[] arr) {
		int i = 0, j = 0, k = arr.length - 1;

		while (j <= k) {
			if (arr[j] == 0) {
				swap(arr, i, j);
				++i;
				++j;
			} else if (arr[j] == 2) {
				swap(arr, k, j);
				--k;
			} else {
				++j;
			}
		}

	}

	public static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 0 };
		display(arr);
		sort012(arr);
		display(arr);

	}

}
