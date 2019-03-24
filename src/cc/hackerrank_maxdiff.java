package cc;

import java.util.ArrayList;
import java.util.List;

public class hackerrank_maxdiff {

	public static String productName(List<String> names) {

		String rv = "";

		int[][] arr = new int[5][26];

		for (String str : names) {
			for (int i = 0; i < 5; ++i) {
				arr[i][str.charAt(i) - 97]++;
			}
		}

		for (int i = 0; i < 5; ++i) {
			int min = Integer.MAX_VALUE,chat=25;
			for (int j = 25; j >= 0; --j) {
				if(min>arr[i][j]) {
					min=arr[i][j];
					chat=j;
				}
			}

			rv += (char) (chat + 97);
		}

		return rv;
	}

	public static void main(String[] args) {
		String str1 = "ready";
		String str2 = "stedy";
		String str3 = "zebra";
		List<String> list = new ArrayList<String>();
		list.add(str3);
		list.add(str2);
		list.add(str1);
		System.out.println(productName(list));
	}

}
