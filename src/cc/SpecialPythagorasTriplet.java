package cc;

import java.util.*;

public class SpecialPythagorasTriplet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = 3002;
		int[] arr = new int[size];
		arr[0] = arr[1] = -1;
		for (int k = 1; k < size - 2; ++k) {
			int ans = -1;

			for (int i = 1; i < size - 1; ++i) {
				for (int j = i + 1; j < size; ++j) {

					int x = i * i + j * j;
					int y = (int) Math.sqrt(x);
					if (y * y == x && i + j + y == k) {
						ans = Math.max(i * y * j, ans);
						break;
					}
				}
			}
			arr[k] = ans;
		}

		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();

			System.out.println(arr[n]);
		}
		in.close();
	}
}
