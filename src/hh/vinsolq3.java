package hh;

public class vinsolq3 {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		
		System.out.println();
	}

	public static void fun(int[] arr) {
		int i = 0, j = 0;

		while (j < arr.length) {
			if (arr[j] < 0) {
				swap(arr, i, j);
				++i;
				++j;
			} else {
				++j;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr= {1,2,-3,4,5,-5,6,-7};
		display(arr);
		fun(arr);
		display(arr);
	}

}
