package cc;

import java.util.HashSet;
import java.util.Scanner;

public class hackerearth_mishaAndNumbers {

	public static boolean che = false;

	public static void permute(HashSet<Integer> set, String str, int l, int r) {
		if (l == r) {
			set.add(Integer.parseInt(str));
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(set, str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	private static void checkPermute(HashSet<Integer> set, String str, int parseInt, int l, int r) {
		if (l == r) {
			if (set.contains(parseInt - Integer.parseInt(str))) {
				che = true;
				return;
			}
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				checkPermute(set, str, parseInt, l+1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		while (t-- > 0) {
			che = false;
			String[] str = sc.nextLine().trim().split("\\s+");
			HashSet<Integer> set = new HashSet<Integer>();
			permute(set, str[1], 0, str[1].length() - 1);
			checkPermute(set, str[2], Integer.parseInt(str[3]), 0, str[2].length() - 1);
			if (che) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
