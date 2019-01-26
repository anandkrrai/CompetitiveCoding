package cc;

import java.util.*;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

public class gfg_minimumPlatform {

	public static void main(String[] args) {
//		wrongApproach();
//		right();
		geeksAns();
	}

	private static void geeksAns() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int[] dep = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			for (int i = 0; i < n; ++i) {
				dep[i] = scan.nextInt();
			}

			Arrays.sort(arr);
			Arrays.sort(dep);

			int i = 0, j = 0, num = 1, platforms = 0;
			while (i < n && j < n) {
				platforms = Math.max(platforms, num);

				if (arr[i] < dep[j]) {
					++num;
					++i;
				} else {
					--num;
					++j;
				}
			}

			System.out.println(platforms);
		}
	}

	public static class Train {
		int arr;
		int dep;
	}

	public static class SortByArr implements Comparator<Train> {
		public int compare(Train t1, Train t2) {
			return t1.arr - t2.arr;
		}
	}

	private static void right() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int[] dep = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			for (int i = 0; i < n; ++i) {
				dep[i] = scan.nextInt();
			}

			ArrayList<Train> trains = new ArrayList<>();

			for (int i = 0; i < arr.length; ++i) {
				Train ti = new Train();
				ti.arr = arr[i];
				ti.dep = dep[i];

				trains.add(ti);
			}

			Collections.sort(trains, new SortByArr());

			int[] set = new int[n];

			Arrays.fill(set, 1);

			Train curr, prev = trains.get(0);
			for (int i = 1; i < n; ++i) {
				curr = trains.get(i);
				if (curr.arr <= prev.dep) {
					set[i] += set[i - 1];
				}
				prev = curr;
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; ++i) {
				if (max < set[i]) {
					max = set[i];
				}
			}

			System.out.println(max);

		}
		scan.close();
	}

	private static void wrongApproach() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int[] dep = new int[n];

			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			for (int i = 0; i < n; ++i) {
				dep[i] = scan.nextInt();
			}

			int[] set = new int[n];

			Arrays.fill(set, 1);
			for (int i = 1; i < n; ++i) {
				if (arr[i] < dep[i - 1]) {
					set[i] += set[i - 1];
				}
			}

			int min = 1;
			for (int i = 0; i < n; ++i) {
				if (min < set[i]) {
					min = set[i];
				}
			}

			System.out.println(min);

		}
		scan.close();
	}

}
