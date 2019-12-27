package dp;

import java.util.*;

public class PrintAllPalindrome {

	public static List<List<String>> partition(String s) {
		boolean[][] arr = new boolean[s.length()][s.length()];

		for (int gap = 0; gap < arr.length; ++gap) {
			for (int i = 0, j = i + gap; j < arr.length; ++j, ++i) {
				if (gap == 0) {
					arr[j][j] = true;
				} else if (gap == 1) {
					arr[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					arr[i][j] = s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1];
				}
			}
		}

		List<List<String>> PalinList = new ArrayList<>();
		Helper(PalinList, new ArrayList<String>(), s, arr, 0);

		return PalinList;
	}

	public static void Helper(List<List<String>> PalinList, ArrayList<String> list, String str, boolean[][] arr,
			int vidx) {
		if (vidx == arr.length) {

			ArrayList<String> lis = new ArrayList<>();
			for (String s : list)
				lis.add(s);
			PalinList.add(lis);
			return;
		}

		for (int i = vidx; i < arr.length; ++i) {
			if (arr[vidx][i]) {
				list.add(str.substring(vidx, i + 1));
				Helper(PalinList, list, str, arr, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String str = "aaaab";
		List<List<String>> ans = partition(str);
		for (List<String> lis : ans) {
			System.out.println(lis);
		}
	}

}
