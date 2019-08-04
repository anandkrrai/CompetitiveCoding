package arraysAndstrings;

public class DecodeWays {
	public static int numDecodings1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		if (s.length() == 1) {
			return 1;
		}

		int last = 0, slast = 0, curr = 0;

		if (s.charAt(1) == '0' && s.charAt(0) > 2) {
			last = 1;
			slast = 1;
		} else {
			if (Integer.parseInt(s.substring(0, 2)) <= 26) {
				slast = 1;
				last = 2;
			} else {
				slast = last = 1;
			}
		}

		for (int i = 2; i < s.length(); ++i) {
			if (s.charAt(i) == 0) {
				if (s.charAt(i - 1) > '2' || s.charAt(i - 1) < '1') {
					curr = 0;
				} else {
					curr = last;
				}
			} else {
				if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
					curr = slast + last;
				} else {
					curr = last;
				}
			}
			slast = last;
			last = curr;
		}

		return curr;
	}

	public static int numDecodings(String s) {
		if (s == null) {
			return 0;
		}
		if (s.length() == 0) {
			return 1;
		}

		int rv = 0;
		if (s.charAt(s.length() - 1) > '0')
			rv = numDecodings(s.substring(0, s.length() - 1));

		if (s.length() >= 2 && Integer.parseInt(s.substring(s.length() - 2)) < 27) {
			rv += numDecodings(s.substring(0, s.length() - 2));
		}

		return rv;

	}

	public static void main(String[] args) {
		System.out.println(numDecodings("1230"));
	}

}
