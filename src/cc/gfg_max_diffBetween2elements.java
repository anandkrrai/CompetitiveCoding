package cc;

//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

public class gfg_max_diffBetween2elements {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 90, 10, 110 };
		int size = arr.length;
		System.out.println(maxDiff(arr, size));
	}

	private static int maxDiff(int[] arr, int size) {
		int maxdif = arr[1]-arr[0], min = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] - min > maxdif) {
				maxdif = arr[i] - min;
			}
			
			if(arr[i]<min) {
				min = arr[i];

			}
		}

		return maxdif;
	}

}
