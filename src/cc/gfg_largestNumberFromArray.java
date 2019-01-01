package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class gfg_largestNumberFromArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();

		while (t-- > 0) {
			int n = scanner.nextInt();

			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; ++i) {
				list.add(scanner.nextInt());
			}

			Comparator c = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					String str1 = o1 + "" + o2;
					String str2 = o2 + "" + o1;

					o1 = Integer.parseInt(str1);
					o2 = Integer.parseInt(str2);

					return o2.compareTo(o1);
				}

			};
			Collections.sort(list, c);

			for (Integer in : list) {
				System.out.print(in);
			}
			System.out.println();

		}

		scanner.close();

	}

}
