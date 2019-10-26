import java.util.List;

public class ShortestCompleatingWord {

	public String shortestCompletingWord(String lp, String[] words) {
		int[] arr = new int[26];
		lp = lp.toLowerCase();
		for (int i = 0; i < lp.length(); ++i) {
			char ch = lp.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				arr[ch - 'a']++;
		}

		String rv = null;

		for (String word : words) {
			String temp = word;
			word = word.toLowerCase();
			int[] arr2 = new int[26];
			for (int i = 0; i < word.length(); ++i) {
				char ch = word.charAt(i);
				if (ch >= 'a' && ch <= 'z')
					arr2[ch - 'a']++;
			}

			boolean flag = true;
			for (int i = 0; i < 26; ++i) {
				if (arr[i] != arr2[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				if (rv == null || rv.length() > word.length())
					rv = temp;
			}
		}
		return rv;
	}

	public void permute(List<String> rv, String s, int vidx) {
		if (vidx == s.length()) {
			rv.add(s);
			return;
		}
		if (Character.isDigit(s.charAt(vidx))) {
			permute(rv, s, vidx + 1);
		} else {
			permute(rv, s, vidx + 1);
			permute(rv, s.substring(0, vidx) + (char) (s.charAt(vidx) - 32) + s.substring(vidx + 1), vidx + 1);
		}
	}

	public static void main(String[] args) {
		System.out.println((int) 'a' - 'A');
	}

}
