package cc;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.geeksforgeeks.org/majority-element/

import java.util.Scanner;

public class gfg_MajorityElement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; ++i) {
				arr[i] = scan.nextInt();
			}

			HashMap<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < arr.length; ++i) {
				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
				} else {
					map.put(arr[i], 1);
				}
			}

			ArrayList<Integer> list = new ArrayList<>(map.keySet());
			int max = 0;
			for (Integer x : list) {
				if (map.get(x) > (n ) / 2) {
					System.out.println(x);
					max = 1;
					break;
				}
			}
			if (max == 0) {
				System.out.println(-1);
			}
		}
		scan.close();
	}

}
