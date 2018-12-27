package cc;

import java.util.Arrays;
import java.util.Scanner;

public class hackerearth_superiorSubstring {

	public static class Helper {

		int[] table = new int[26];

		public Helper() {
			// TODO Auto-generated constructor stub
			table = new int[26];
			Arrays.fill(table, 0);
		}

		public int[] minus(Helper arg) {
			int[] rv = new int[26];

			for (int i = 0; i < 26; ++i) {
				rv[i] = arg.table[i] - this.table[i];
			}

			return rv;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		while (t > 0) {
			--t;

			int n = s.nextInt();
			s.nextLine();

			String string = s.nextLine();

			Helper[] helper = new Helper[n];

			int ch;

			for (int i = 0; i < n; ++i) {
				helper[i] = new Helper();
			}

			for (int i = 0; i < string.length(); ++i) {
				ch = string.charAt(i) - 97;
				helper[i].table[ch]++;
			}

			int[] temp;
			int ans = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = i+1; j < n; ++j) {
					temp = helper[i].minus(helper[j]);
					for (int k = 0; k < 26; ++k) {
						if (temp[k] > (j - i) / 2) {
							++ans;
							break;
						}
					}
				}
			}
			System.out.println(ans);

		}
		s.close();

	}

}
