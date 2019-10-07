package arraysAndstrings;

public class DecodeString {
	public String decodeString(String s) {
		String str = "", num = "";
		StringBuilder rv = new StringBuilder("");
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch >= '0' && ch <= '9') {
				num += ch;
			} else if (ch == '[') {
				str = "";
			} else if (ch == ']') {
				int n = Integer.parseInt(num);
				num = "";
				for (int j = 0; j < n; ++j) {
					rv.append(str);
				}
			} else {
				str += ch;
			}
		}
		return rv.toString();
	}

}
