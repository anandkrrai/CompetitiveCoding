package map_set;

import java.util.*;

public class find_common_char {

	public static ArrayList<String> commonChars(String[] A) {
		int[] arr = new int[26];
		int[] temp = new int[26];

		Arrays.fill(arr, Integer.MAX_VALUE);

		for (String str : A) {

			for (int i = 0; i < str.length(); ++i) {
				temp[str.charAt(i) - 'a']++;
			}

			for (int i = 0; i < 26; ++i) {
				arr[i] = Math.min(arr[i], temp[i]);
			}

			Arrays.fill(temp, 0);
		}

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 26; ++i) {
			int val = arr[i];
			char ch = (char) (arr[i] + 'a');
			while (val-- > 0) {
				list.add(ch + "");
			}
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
