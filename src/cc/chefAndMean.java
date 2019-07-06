package cc;

import java.util.HashMap;
import java.util.Scanner;

public class chefAndMean {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			HashMap<Double, Integer> map = new HashMap<>();
			double sum = 0;

			for (int i = 1; i <= n; ++i) {
				int val = scan.nextInt();
				sum += val;
				if (!map.containsKey((double)val)) {
					map.put((double)val, i);
				}
			}

			sum /= n;

			if (map.containsKey(sum)) {
				System.out.println((int)map.get(sum));
			} else {
				System.out.println("Impossible");
			}
		}
	}

}
