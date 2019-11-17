package arraysAndstrings;

import java.util.Scanner;

public class countDashes {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] arr = { 6, 2, 5, 5, 4, 5, 6, 4, 7, 6 };
		int ans = 0;
		for (int i = 0; i < s.length(); ++i) {
			ans += arr[s.charAt(i) - '0'];
		}
		System.out.println(ans);
	}
}
