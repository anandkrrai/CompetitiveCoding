package arraysAndstrings;

import java.util.Scanner;

public class parasAndHisGirlFriend {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		int m = scan.nextInt();

		int[] arr = new int[n + 1];
		int[][] querry = new int[q][2];

		for (int i = 0; i < q; ++i) {
			querry[i][0] = scan.nextInt();
			querry[i][1] = scan.nextInt();

			arr[querry[i][0]]++;
			arr[querry[i][1] + 1]--;
		}

		int count = 0, sum = 0, local = 0;

		for (int i = 0; i < q; ++i) {

			arr[querry[i][0]]--;
			arr[querry[i][0] + 1]++;

			local = 0;
			sum = 0;
			for (int i1 = 0; i1 < arr.length; ++i1) {
				sum += arr[i1];
				if (sum == m)
					++local;
			}
			count = Math.max(count, local);

			arr[querry[i][0]]++;
			arr[querry[i][0] + 1]--;

		}

		System.out.println(count);

	}

}
