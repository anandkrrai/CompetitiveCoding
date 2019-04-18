package cc;

import java.util.*;

public class a {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		int count = 0;

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < s.length() - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				s = s.substring(0, i) + s.substring(i + 1);
				++count;
				--i;
			}
		}

		return count;

	}

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String str : magazine) {
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}

		}

		for (String str : note) {
			if (!map.containsKey(str)) {
				System.out.println("No");
				return;
			} else {
				int rv = map.get(str);

				map.remove(str);
				--rv;
				if (rv >= 1)
					map.put(str, rv);
			}
		}

		System.out.println("Yes");
	}

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int zero = 0, one = 0, minus = 0;
		for (int x : arr) {
			if (x < 0) {
				++minus;
			} else if (x == 0) {
				++zero;
			} else {
				++one;
			}
		}
		int size = arr.length;
		double minu = (double)(minus / size);
		double zer = (double)(zero / size);
		double pos = (double)(one / size);
// double x = (double)2/3;
		// System.out.println(x);
		System.out.println(minu);
		System.out.println(zer);
		System.out.println(pos);

	}

	private static final Scanner scanner = new Scanner(System.in);
	private static final String str = "anand";

	public static void main(String[] args) {
		double x = (double) 2 / 3;
		System.out.println(x);

		int[] arr = { -4, 3, -9, 0, 4, 1 };
		plusMinus(arr);

//		String str = "hackerearth hackathons";
//		StringTokenizer val = new StringTokenizer(str, "h");
//		while (val.hasMoreElements()) {
//			System.out.print(val.nextToken());
//		}

//		String[] mn = scanner.nextLine().split(" ");
//
//		int m = Integer.parseInt(mn[0]);
//
//		int n = Integer.parseInt(mn[1]);
//
//		String[] magazine = new String[m];
//
//		String[] magazineItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < m; i++) {
//			String magazineItem = magazineItems[i];
//			magazine[i] = magazineItem;
//		}
//
//		String[] note = new String[n];
//
//		String[] noteItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			String noteItem = noteItems[i];
//			note[i] = noteItem;
//		}
//
//		checkMagazine(magazine, note);
//
//		scanner.close();
	}
}
