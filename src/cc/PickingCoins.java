package cc;

import java.util.Scanner;

public class PickingCoins {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {

			--t;
			long n = scan.nextInt();
			long k = scan.nextInt();
			long runner = k;
			boolean flag = false;
			// alice = 1, bob =2

			while (n - runner >= 0) {
				if (n - 2 * runner < 0) {
					System.out.println("Alice");
					flag = true;
					break;
				}
				n -= 2 * runner;
				runner *= k;
			}

			if (!flag) {
				System.out.println("Bob");
			}			
		}
		scan.close();
	}
}
