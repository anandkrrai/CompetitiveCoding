package cc;

import java.util.*;

public class gfg_findTheFine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		LinkedList<Integer> h = new LinkedList<>();
//		int a = h.removeLast();

		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int date = scan.nextInt();

			int[] car_num = new int[n];
			int[] fine = new int[n];

			for (int i = 0; i < n; ++i) {
				car_num[i] = scan.nextInt();
			}
			for (int i = 0; i < n; ++i) {
				fine[i] = scan.nextInt();
			}

			int ans = 0;
			if (date % 2 != 0) {
				for (int i = 0; i < n; ++i) {
					if (car_num[i] % 2 == 0) {
						ans += fine[i];
					}
				}
			} else {
				for (int i = 0; i < n; ++i) {
					if (car_num[i] % 2 != 0) {
						ans += fine[i];
					}
				}
			}
			System.out.println(ans);

		}
		scan.close();
	}
}