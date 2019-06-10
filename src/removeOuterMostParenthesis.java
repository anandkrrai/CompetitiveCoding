
public class removeOuterMostParenthesis {

	public static void main(String[] args) {
		String ss = "anand rai";
		char ch = '+';
		System.out.println((int) ch);
		System.out.println(removeOuterParentheses("()())()()"));
	}

	public static String removeOuterParentheses(String S) {
		S = "(" + S + ")";
		return validate(S, 0, S.length() - 1);
	}

	public static String validate(String str, int start, int end) {
		int count = 0, st = start + 1;
		String ans = "";
		for (int i = start + 1; i <= end - 1; ++i) {
			if (str.charAt(i) == '(') {
				++count;
			} else {
				--count;
			}
			if (count == 0) {
				if (i - st == 1)
					ans += "()";
				else
					ans += str.substring(st + 1, i);
				st = i;
			}
		}

		return ans;
	}

}
