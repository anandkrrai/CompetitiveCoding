package map_set;

import java.util.*;

public class findCommonCharacters {
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
			char ch = (char) (i + 'a');
			while (val-- > 0) {
				list.add(ch + "");
			}
		}

		return list;
	}

	// Don't make any changes here.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] A = new String[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = s.nextLine();
		}

		ArrayList<String> res = commonChars(A);
		Collections.sort(res);
		System.out.println(res);

	}
}
