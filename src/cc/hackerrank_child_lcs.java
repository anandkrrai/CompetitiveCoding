package cc;

public class hackerrank_child_lcs {

	public static void main(String[] args) {
		System.out.println(child("abcd", "abdc"));
	}

	private static int child(String str1, String str2) {
		int[][] arr = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < str1.length(); ++i) {
			for (int j = 0; j < str2.length(); ++j) {

				if (str1.charAt(i) == str2.charAt(j)) {
					arr[i+1][j+1] = arr[i ][j] + 1;
				} else {
					arr[i+1][j+1] = Math.max(arr[i ][j+1], arr[1+i][j ]);
				}
			}

		}

		return arr[str1.length()][str2.length()];
	}

}
