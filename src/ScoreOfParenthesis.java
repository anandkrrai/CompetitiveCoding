
public class ScoreOfParenthesis {

	public static void main(String[] args) {
		System.out.println(scoreOfParentheses("(()())()"));
	}

	public static int scoreOfParentheses(String S) {
		S = "(" + S + ")";
		return calcAns(S, 0, S.length() - 1) / 2;
	}

	public static int calcAns(String str, int start, int end) {
		if (end - start == 1) {
			//smallest possible valid parenthesis -> () , therefore score =1

			return 1;
		}

		int ans = 0, count = 0, st = start + 1;
		for (int i = start + 1; i <= end - 1; ++i) {
			if (str.charAt(i) == '(')
				++count;
			else
				--count;

			if (count == 0) {
				//st is maintained so that the string inside the parenthesis can be divided
				ans += calcAns(str, st, i);
				st = i + 1;
			}
		}

		return ans * 2;
	}

}
