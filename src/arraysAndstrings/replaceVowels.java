package arraysAndstrings;

import java.util.*;

public class replaceVowels {

	public static String reverseVowels(String s) {
		int left = 0, right = s.length() - 1;
		StringBuilder sb = new StringBuilder(s);
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');   
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		while (left < right) {
			while (left < sb.length() && !set.contains(sb.charAt(left))) {
				++left;
			}
			while (right >= 0 && !set.contains(sb.charAt(right))) {
				--right;
			}

			if (right < left)
				break;
			char ch = sb.charAt(left);
			sb.setCharAt(left, sb.charAt(right));
			sb.setCharAt(right, ch);
			--right;
			++left;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "aA";
		System.out.println(reverseVowels(str));
	}

}
