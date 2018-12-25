package cc;

import java.util.HashMap;
import java.util.Scanner;

public class questionPaper {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();

			HashMap<Integer, Boolean> map = new HashMap<>();

			for (int i = 0; i <= n; ++i) {
				for (int j = 0; j + i <= n; ++j) {
					map.put(i * a - j * b, true);
				}
			}

			System.out.println(map.size());
		}
		scan.close();

	}

}
