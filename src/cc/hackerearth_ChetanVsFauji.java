package cc;

import java.util.HashMap;
import java.util.Scanner;

public class hackerearth_ChetanVsFauji {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		int temp = n, count = 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (temp-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = x + y;
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
			++i;
		}

		int s = sc.nextInt();

		for (i = 0; i < n; ++i) {
			if (map.containsKey(s + arr[i]))
				count += map.get(s + arr[i]);

		}

		System.out.println(count);

	}

}
