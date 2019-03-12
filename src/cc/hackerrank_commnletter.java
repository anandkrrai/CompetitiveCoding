package cc;

import java.util.Scanner;

public class hackerrank_commnletter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();

		while (t-- > 0) {
			String str1 = scanner.nextLine();
			String str2 = scanner.nextLine();

			int[] arr1 = new int[26];
			for (int i = 0; i < str1.length(); ++i) {
				arr1[str1.charAt(i) - 97]++;

			}
			boolean flag = false;
			for (int i = 0; i < str2.length(); ++i) {
				if (arr1[str2.charAt(i) - 97] >= 1) {
					System.out.println("YES");
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println("NO");
			}
		}
	}

}
