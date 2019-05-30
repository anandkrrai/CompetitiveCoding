package hh;

import java.util.Arrays;
import java.util.Scanner;

public class jio_code_gladiators {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0)

		{
			int n = scan.nextInt();
			int[] villan = new int[n];
			for (int i = 0; i < n; ++i) {
				villan[i] = scan.nextInt();

			}

			Arrays.sort(villan);

			int[] player = new int[n];
			for (int i = 0; i < n; ++i) {
				player[i] = scan.nextInt();

			}

			Arrays.sort(player);

			boolean won = true;

			for (int i = 0; i < n; ++i) {
				if (villan[i] > player[i]) {
					won = false;
					break;

				}
			}
			
			if(won) {
				System.out.println("WON");
			}else {
				System.out.println("LOSE");
			}
		}

		scan.close();
	}

}
