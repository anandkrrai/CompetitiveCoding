package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class keyPad {

	public static ArrayList<String> getKPC(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}

		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();

		String choices = codes[ch - '0'];
		for (String rs : rr) {
			for (int i = 0; i < choices.length(); i++) {
				String ms = choices.charAt(i) + rs;
				mr.add(ms);
			}
		}

		return mr;
	}

	public static int keyPad(String str, String[] codes, String ans) {
		ArrayList<String> mr = getKPC(str);
		Collections.sort(mr);
		for(String s: mr) {
			System.out.println(s);
		}
		
		return mr.size();

	}

	// Given keypad sequence respective to mobile digit number
	static String[] codes = { ".", "abc", "def", "gh", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		System.out.println(keyPad(s, codes, ""));
	}

}
