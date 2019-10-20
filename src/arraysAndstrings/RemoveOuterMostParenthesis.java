package arraysAndstrings;

public class RemoveOuterMostParenthesis {
	public static String removeOuterParentheses(String S) {
		StringBuilder sb = new StringBuilder(S.substring(1, S.length() - 1));
		int bal = 0;
		for (int i = 0; i < sb.length() && i >= 0;) {
			if (sb.charAt(i) == '(') {
				++bal;
			} else {
				--bal;
			}
			if (bal < 0) {
				sb.deleteCharAt(i);
				bal = 0;
			} else {
				++i;
			}
		}
		bal = 0;

		for (int i = sb.length() - 1; i >= 0 && i < sb.length(); --i) {
			if (sb.charAt(i) == '(') {
				--bal;
			} else {
				++bal;
			}
			if (bal < 0) {
				sb.deleteCharAt(i);
				bal = 0;
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())"));
	}

}
