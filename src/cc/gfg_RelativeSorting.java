package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class gfg_RelativeSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				int temp = sc.nextInt();

				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				} else {
					map.put(temp, 1);
				}
			}

			int[] arr = new int[m];
			for (int i = 0; i < m; ++i) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < m; ++i) {
				if (!map.containsKey(arr[i])) {
					continue;
				}
				int freq = map.get(arr[i]);
				for (int j = 0; j < freq; ++j) {
					System.out.print(arr[i] + " ");
				}
				map.remove(arr[i]);
			}

			ArrayList<Integer> list = new ArrayList<>(map.keySet());
			ArrayList<Integer> ans = new ArrayList<>();

			for (int i = 0; i < list.size(); ++i) {
				int element = list.get(i);
				int freq = map.get(element);
				for (int j = 0; j < freq; ++j) {
					ans.add(element);
				}
				map.remove(element);
			}

			Collections.sort(ans);
			for (int ele : ans) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
