package cc;

import java.util.ArrayList;

public class recurr_class {

	public static void main(String[] args) {
		ArrayList<String> ml = seq("ab");
		for (String str : ml) {
			System.out.println(str);
		}

//		printCombinations("179", "");

	}

	public static ArrayList<String> seq(String str) {
		if (str.length() == 0) {
			ArrayList<String> rv = new ArrayList<String>();
//			rv.add(str.charAt(0) + "");
//			rv.add((int) str.charAt(0) + "");
//			rv.add(str);
			rv.add("");
			return rv;
		}
		ArrayList<String> ml = new ArrayList<String>();
		ArrayList<String> rv = seq(str.substring(1));

		char ch = str.charAt(0);
		for (String st : rv) {
			ml.add(ch + st);
			ml.add((int) ch + st);
			ml.add(st);

		}

		return ml;

	}

	public static String options(char num) {
		String rv = "";

		switch (num) {
		case '0': {
			rv = ".";
			break;
		}
		case '1': {
			rv = "abc";
			break;

		}
		case '2': {
			rv = "def";
			break;
		}
		case '3': {
			rv = "ghi";
			break;
		}
		case '4': {
			rv = "jkl";
			break;
		}
		case '5': {
			rv = "mno";
			break;
		}
		case '6': {
			rv = "pqr";
			break;
		}
		case '7': {
			rv = "st";
			break;
		}
		case '8': {
			rv = "uvwx";
			break;
		}
		case '9': {
			rv = "yz";
			break;
		}
		}

		return rv;

	}

	public static void printCombinations(String num, String output) {

		if (num.length() == 0) {
			System.out.println(output);
			return;
		}

		String str = options(num.charAt(0));

		for (int i = 0; i < str.length(); ++i) {
			printCombinations(num.substring(1), output + str.charAt(i));
		}

	}

}
