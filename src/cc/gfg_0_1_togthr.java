package cc;

public class gfg_0_1_togthr {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 0, 0,0, 1, 1, 0, 1 };

		int i = -1, temp, j = 0;

		for (j = 0; j < arr.length; ++j) {
			if (arr[j] < 1) {
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
