package cc;

//https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/

public class gfg_max_length_of_biotonicSequence {

	public static void main(String[] args) {
		int arr[] = { 40, 30, 20, 10 };

		int inc[] = new int[arr.length];
		int dec[] = new int[arr.length];

		inc[0] = 1;
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i - 1] < arr[i]) {
				inc[i] = inc[i - 1] + 1;
			} else {
				inc[i] = 1;
			}
		}

		dec[arr.length - 1] = 1;

		for (int i = arr.length - 2; i >= 0; --i) {
			if (arr[i] > arr[i + 1]) {
				dec[i] = dec[i + 1]+1;
			} else {
				dec[i] = 1;
			}
		}

		int ans = -1;
		for (int i = 0; i < arr.length; ++i) {
			if (inc[i] + dec[i] - 1 > ans) {
				ans = inc[i] + dec[i] - 1;
			}
		}

		System.out.println(ans);

	}

}
