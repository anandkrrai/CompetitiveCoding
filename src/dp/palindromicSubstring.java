package dp;

public class palindromicSubstring {

	public static int countSubstrings(String s) {
		int[][] arr = new int[s.length()][s.length()];
		boolean[][] bool = new boolean[s.length()][s.length()];

		for (int gap = 0; gap < s.length(); ++gap) {
			for (int i = 0, j = i + gap; j < s.length(); ++i, ++j) {
//				System.out.println(gap + " " + i + " " + j);
				if (gap == 0) {
					arr[i][j] = 1;
					bool[i][j] = true;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						arr[i][j] = 3;
						bool[i][j] = true;
					} else {
						arr[i][j] = 2;
					}
				} else {
					if (bool[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
						arr[i][j] = arr[i + 1][j] + arr[i][j - 1] - arr[i + 1][j - 1] + 1;
						bool[i][j] = true;
					} else {
						arr[i][j] = arr[i + 1][j] + arr[i][j - 1] - arr[i + 1][j - 1];
					}
				}
			}
		}

		printMatrix(s, arr);
		return arr[0][s.length() - 1];
	}

	private static void printMatrix(String s, int[][] arr) {
		System.out.print("  ");
		for (int i = 0; i < s.length(); ++i)
			System.out.print(s.charAt(i) + " ");
		System.out.println();
		int k = 0;
		for (int ar[] : arr) {
			System.out.print(s.charAt(k) + " ");
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
			++k;
		}
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("dbabcccbcdbbbadabbdabaabcbbabaacdadcdbbbbdddbcbbbcbcabacacdaadaadcdccbacdaadadcbaacabbddabdadcabbccadacadaaacbbddaaababacaabbbacaccbcbbabddbbcccaaacbcdcabcbacdbddcdcadaaadcbccbbcabbcbdaadcbddaacacdadacbbdabcdcdadccaccdbdddddcabdbcdbaadacadadbabdcdbbadaacdbadcdabdbbcabbbdaacaaaaadcaabaaaadabaaddcaabdddcbcadcbdbbdbcbcdbadcadacbbcdccddaccccacbacaacbbdadadcacabdabadbbcdbcaaccdbdcabcadbacbccddbabbdacbcbbcbcabcacdaacccaadcdbdccabcaaacaddadcabacdccaaaddaaadbccdbbcccdddababcdbcddcbdddbbbdaadaccbcaabbcbdbadbabbacdbbbdaaccdcabddacadabcccacdabacbcdbcbdabddacacbdbcaacacaabbaaccddabaadbbaabaddbcacbacdbbbacdccabbcdbbbdbdbbcacabdddbdbaaabbcdcbabcbbbccdcdcdcaaddadccbabbacaddcaddcadcdccaccacabbaababdbbcbdcdccccccdadbdbdcdbdadcdcacdaabaacabaacdacdbaaccadbcddbdccabbcabcadcbdadbcdadbbbccacbcbbcaaaabdacbadacaadcadaacdacddcbbabdacacaabccdaccbbcbbcbcaacdabdcbcdbccdbcbcbddaacdacaaaddcaddcadccacbaddbbbccbbbcbbcbadcabbccbbaadaacacabddbdbddcadbdaaccadbcccabdcdbadbbacbcbbcdcabcddcddddabddbdabdcabdbdbbbcdbcdabbdcb"));
	}

}
