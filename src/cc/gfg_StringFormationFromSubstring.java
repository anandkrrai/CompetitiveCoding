package cc;

import java.util.HashMap;
import java.util.Scanner;

public class gfg_StringFormationFromSubstring {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int d = scan.nextInt();
			int[] arr = new int[n];
			boolean flag = false;
			HashMap<Integer, Boolean> map = new HashMap<>();
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
				map.put(arr[i], true);
				if (map.containsKey(Math.abs(d - arr[i]))) {
					flag = true;
				}
			}

			if (flag) {
				System.out.println("1");
			} else {
				System.out.println(-1);
			}
		}

		scan.close();
		// Scanner scan = new Scanner(System.in);
//		int t = scan.nextInt();
//		scan.nextLine();
//		while (t-- > 0) {
//			String str = scan.nextLine();
//			String pattern = str.charAt(0) + "";
//
//			for (int i = 0; i <= str.length() / 2; ++i) {
//				String tst = str.substring(i - i % pattern.length(), i + 1);
//
//				if (!tst.equals(pattern)) {
//					pattern = str.substring(0, i + 1);
//				}
//			}
//
//			if (pattern.length() == str.length()) {
//				System.out.println("False");
//			} else {
//				System.out.println("True");
//			}
//		}
//
//		scan.close();

	}

}
