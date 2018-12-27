package cc;

import java.io.*;
import java.util.*;

public class gfg_phone_directory_wrong{

	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine());

		while (t > 0) {
			--t;
			int n = Integer.parseInt(bufferedReader.readLine());
			String[] arr = bufferedReader.readLine().trim().split("\\s+");

			String query = bufferedReader.readLine();

			Arrays.sort(arr);
			String temp;
			for (int i = 0; i <= arr.length / 2; ++i) {
				temp = arr[i];
				arr[arr.length - 1 - i] = arr[i];
				arr[i] = temp;
			}

			int count = 0, len = arr.length;
			while (count != query.length()) {
				if (len == 0) {
					System.out.println(0);
				}
				for (int i = arr.length - 1; i >= 0; ++i) {
					if (arr[i].length() >= count + 1) {
						if (arr[i].charAt(count) == query.charAt(count)) {
							System.out.print(arr[i] + " ");
						} else {
							int k = i;
							while (k < arr.length - 1) {
								arr[k] = arr[k + 1];
								++k;
							}
						}
					}
				}
				++count;
			}

		}

	}
}