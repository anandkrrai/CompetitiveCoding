package dp;

import java.util.*;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>();
		for (String str : wordDict)
			set.add(str);

		int[] arr = new int[s.length() + 1];
		arr[0] = 1;
		find(s, 0, "", set, arr);
		return arr[arr.length - 1] <= 0 ? false : true;
	}

	public static void find(String str, int i, String word, HashSet<String> set, int[] arr) {
		if (i >= str.length())
			return;
		if (set.contains(word)) {
			arr[i + 1] += arr[i + 1 - word.length()];
			find(str, i + 1, "" + str.charAt(i), set, arr);

		}
		find(str, i + 1, word + str.charAt(i), set, arr);
	}

	public static void main(String[] args) {

		
		String g = "087";
//		int x = 087;
		System.out.println(Integer.parseInt(g) + 1);
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		list.add("aaa");
		System.out.println(wordBreak("aaaaaaa", list));
	}

}
