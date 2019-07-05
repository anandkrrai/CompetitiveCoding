package arraysAndstrings;

import java.util.*;

public class a {

	private static List<String> subStringList = new ArrayList<String>();

	public static int getSubStringCount(String s) {

		if (s.length() == 0)
			return 0;

		int len = s.length();

		if (subStringList.contains(s)) {
			return getSubStringCount(s.substring(1)) + 
					getSubStringCount(s.substring(0, len - 1));
		} else {
			subStringList.add(s);
			System.out.println(s);
			return 1 + getSubStringCount(s.substring(1)) + 
					   getSubStringCount(s.substring(0, len - 1));
		}

	}

	public static void main(String[] args) {
		String s = "abcd";
		int count = getSubStringCount(s);
		System.out.println(count);
		subStringList.clear();
	}

}
