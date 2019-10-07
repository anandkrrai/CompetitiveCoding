package dp;

public class longestPalindrome {
	public static String longestPalindrome(String str) {
		if (str == null || str.length() <= 1)
			return str;
		String rv = "";

		for (int i = 0; i < str.length(); ++i) {
			for (int orbit = 0; orbit <= str.length() / 2 && i - orbit >= 0 && i + orbit < str.length(); ++orbit) {
				if (str.charAt(i - orbit) != str.charAt(i + orbit))
					break;
				else {
					if (2 * orbit + 1 > rv.length())
						rv = str.substring(i - orbit, i + orbit + 1);
				}
			}
		}

		for (float i = 0.5F; i < str.length(); i += 1F) {
			for (float orbit = 0.5F; orbit <= str.length() / 2 && i - orbit >= 0
					&& i + orbit < str.length(); orbit = orbit + 1F) {
				if (str.charAt((int) (i - orbit)) != str.charAt((int) (i + orbit)))
					break;
				else {
					if (2 * orbit + 1 > rv.length())
						rv = str.substring((int) (i - orbit), (int) (i + orbit + 1));
				}
			}
		}

		return rv;
	}

	public static void main(String[] args) {
System.out.println(longestPalindrome("annad"));
	}

}
