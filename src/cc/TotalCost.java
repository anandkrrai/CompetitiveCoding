package cc;

import java.util.Scanner;

public class TotalCost {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int s = scan.nextInt();
		int t = scan.nextInt();
		int h = scan.nextInt();
		int x = scan.nextInt();

		int ans = 0, temp;
		if (s > t) {
			temp = (s - t );
			if (temp >= x) {
				ans = x * p;
			} else {
				ans = temp * p;
				x -= temp;
				ans += x * h;
			}
		}

		System.out.println(ans);

	}

}
