package arraysAndstrings;

import java.util.HashMap;

public class bold {

	public static String addBoldTag(String s, String[] dict) {
		boolean[] bold = new boolean[s.length()];
		for (String d : dict) {
			for (int i = 0; i <= s.length() - d.length(); i++) {
				if (s.substring(i, i + d.length()).equals(d)) {
					for (int j = i; j < i + d.length(); j++)
						bold[j] = true;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length();) {
			if (bold[i]) {
				res.append("<b>");
				while (i < s.length() && bold[i])
					res.append(s.charAt(i++));
				res.append("</b>");
			} else
				res.append(s.charAt(i++));
		}
		return res.toString();
	}

	public static String addBoldTag_1(String s, String[] dict) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (String str : dict) {
			int st = s.indexOf(str);
			if (st == -1)
				continue;
			int end = st + str.length() - 1;
			boolean flag = false;
			for (int start : map.keySet()) {
				if (start <= st && map.get(start) >= st) {
					map.put(start, end);
					flag = true;
					break;
				}
			}
			if (!flag) {
				map.put(st, end);
			}
		}

		boolean[] arr = new boolean[s.length()];

		for (int st : map.keySet()) {
			for (int i = st; i <= map.get(st); ++i) {
				arr[i] = true;
			}
		}

		boolean set = false;
		String rv = "";

		for (int i = 0; i < s.length(); ++i) {
			if (!set && arr[i] == true) {
				rv += "<b>";
			} else if (set && arr[i] == false) {
				rv += "</b>";
			}
			rv += s.charAt(i);
		}

		return rv;
	}

	public static void main(String[] args) {
		String str = "anand";
		System.out.println(str.indexOf("and"));
	}
}
