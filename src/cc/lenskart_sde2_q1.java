package cc;

import java.util.HashMap;
import java.util.Scanner;

public class lenskart_sde2_q1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		scan.close();

		int sum = 0, maxlen = 0, index;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {

			if (str.charAt(i) == '1') {
				++sum;
			} else {
				--sum;
			}

			if (sum < 0) {
				maxlen = Math.max(i + 1, maxlen);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			if (map.containsKey(sum + 1)) {
				index = map.get(sum + 1);
				maxlen = Math.max(i - index, maxlen);
			}

		}

		System.out.println(maxlen);
	}

}
