package cc;

//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class gfg_sort012 {
	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		int i = -1, temp, j = 0;

		for (j = 0; j < arr.length; ++j) {
			if (arr[j] < 1) {
				++i;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i = -1;
		for (j = 0; j < arr.length; ++j) {
			if (arr[j] < 2) {
				++i;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		for (int x : arr) {
			System.err.print(x + " ");
		}
	}
}
