package cc;

import java.util.HashMap;
import java.util.Scanner;

public class ChefAndTyping {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;

			int n = scan.nextInt();
			scan.nextLine();

			String[] arr = new String[n];
			for (int i = 0; i < n; ++i) {

				arr[i] = scan.nextLine();
			}

			int time = 0;
			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {

				if (map.containsKey(arr[i])) {
					time += map.get(arr[i]) / 2;
					continue;
				}

				int temp = 0;
				for (int j = 0; j < arr[i].length(); ++j) {
					if (j == 0) {
						temp += 2;
					} else {
						if (arr[i].charAt(j - 1) == 'd' || arr[i].charAt(j - 1) == 'f') {
							if (arr[i].charAt(j) == 'j' || arr[i].charAt(j) == 'k') {
								temp += 2;
							} else {
								temp += 4;
							}
						} else if (arr[i].charAt(j - 1) == 'j' || arr[i].charAt(j - 1) == 'k') {
							if (arr[i].charAt(j) == 'd' || arr[i].charAt(j) == 'f') {
								temp += 2;
							} else {
								temp += 4;
							}
						}
					}

				}
				time += temp;
				map.put(arr[i], temp);
			}
			System.out.println(time);
		}
		scan.close();
	}

}
