package cc;

import java.util.Scanner;

public class ChefAndCardTrick2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int[] arr = new int[2 * n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
				arr[i + n] = arr[i];
			}

			int count = 1;
			int prev = arr[0], curr;

			for (int i = 1; i < arr.length; ++i) {
				curr = arr[i];
				if (prev > curr) {
					count = 1;
				} else {
					++count;
				}
				prev = curr;
				if(count==n) {
					break;
				}
			}

			if (count == n) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
		scan.close();
	}

}
