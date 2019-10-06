package arraysAndstrings;

public class BackSpaceStringComare {
	public String make(String str) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '#') {
				if (sb.length() != 0)
					sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public boolean backspaceCompare(String S, String T) {
		return make(S).equals(make(T));
	}
}
