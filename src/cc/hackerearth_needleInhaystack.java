package cc;

import java.util.Scanner;

public class hackerearth_needleInhaystack {

	public static String hashing(int[] arr) {
		StringBuilder pattern_hash = new StringBuilder();
		for (int i = 0; i < arr.length; ++i) {
			pattern_hash.append(arr[i] + "");
		}
		return pattern_hash.toString();
	}

	private static boolean hashing(int[] arr2, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			if (arr2[i] != arr[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		scan.nextLine();

		while (t-- > 0) {
			String pattern = scan.nextLine();
			String text = scan.nextLine();
			boolean found = false;
			int[] arr2 = new int[26];
			int[] arr = new int[26];

			for (int i = 0; i < pattern.length(); ++i) {
				arr[pattern.charAt(i) - 'a']++;
			}

			for (int i = 0; i < pattern.length(); ++i) {
				arr2[text.charAt(i) - 'a']++;
			}
			found = hashing(arr2, arr);
			int patternLength = pattern.length();
			for (int i = patternLength; i < text.length() && !found; ++i) {
				arr2[text.charAt(i) - 'a']++;
				arr2[text.charAt(i - patternLength) - 'a']--;
				found = hashing(arr2, arr);
				if (found)
					break;
			}

			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		scan.close();
	}

}
