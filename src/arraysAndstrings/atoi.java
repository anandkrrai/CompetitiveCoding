package arraysAndstrings;

public class atoi {
	public static void main(String[] args) {
		System.out.println(myAtoi("2 5"));

	}

	class Solution {
		public static int myAtoi(String str) {
			// System.out.println(str);
			str = str.trim();
			if (str.length() == 0)
				return 0;
			str = str.split("\\s+")[0];
			long ans = 0;
			int sign = 0;
			boolean flag = false;
			for (int i = 0; i < str.length(); ++i) {
				char ch = str.charAt(i);
				if (i == 0 && ch == '+') {
					sign = 0;
				} else if (i == 0 && ch == '-') {
					sign = 1;
				} else if (Character.isDigit(ch)) {
					ans = ans * 10 + (int) (ch - '0');
					if (ans > Integer.MAX_VALUE) {
						ans = Integer.MAX_VALUE;
						flag = true;
						break;
					}
				} else {
					break;
				}
			}

			if (sign == 1) {
				if (flag)
					ans = Integer.MIN_VALUE;
				else
					ans = ans * -1;
			}

			return (int) ans;

		}
	}
}
