package cc;

import java.util.Scanner;

public class codechef_specialIncridient {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		while (t-- > 0) {
			int n = scan.nextInt();
			scan.nextLine();

			boolean[][] arr = new boolean[n][26];

			for (int i = 0; i < n; ++i) {
				String str = scan.nextLine();
				for (int j = 0; j < str.length(); ++j) {
					int temp = (int) str.charAt(j) - 97;
					arr[i][temp] = true;
				}
			}

			int ans = 0;
			boolean flag = true;

			for (int j = 0; j < 26; ++j) {
				flag = true;
				for (int i = 0; i < n; ++i) {
					if (arr[i][j] == false) {
						flag = false;
						break;
					}
				}
				if (flag) {
					++ans;
				}
			}

			System.out.println(ans);

		}

		scan.close();
	}

}
