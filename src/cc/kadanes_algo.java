package cc;

import java.util.*;

class kadanes_algo {

	static Scanner scan = new Scanner(System.in);

	public static void bad_complexity() {
		int n = scan.nextInt();
		int[] arr = new int[n + 1];
		arr[0] = 0;
		int temp = 0, max = -Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; ++i) {
			temp = scan.nextInt();
			arr[i] = arr[i - 1] + temp;
		}

		for (int i = 0; i < arr.length; ++i) {
			for (int j = i + 1; j < arr.length; ++j) {
				temp = arr[j] - arr[i];
				if (max < temp)
					max = temp;
			}
		}

		System.out.println(max);

	}

	public static void main(String[] args) {

		int t = scan.nextInt();
		scan.nextLine();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int temp;
			int max_so_far = 0, global_max = Integer.MIN_VALUE;

			for (int i = 1; i <= n; ++i) {

				temp = scan.nextInt();
				
				max_so_far += temp;

				if (max_so_far > global_max)
					global_max = max_so_far;
				
				if (max_so_far < 0)
					max_so_far = 0;
				


			}

			System.out.println(global_max);

		}
		scan.close();
	}
}