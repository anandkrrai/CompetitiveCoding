package cc;

public class specialPalindrome {

	public static void main(String[] args) {
		System.out.println(palindrome_count("aaaa"));
	}

	private static int palindrome_count(String str) {
		int rv = 0;

		for (int i = 0; i < str.length(); ++i) {
			int len = -1;
			for (int orbit = 0; orbit <= str.length() / 2; ++orbit) {
				if (i + orbit >= str.length() || i - orbit < 0) {
					break;
				} else {
					if (str.charAt(i + orbit) == str.charAt(i - orbit)) {
						len += 2;
						if (len > 3 && str.charAt(i - orbit) != str.charAt(i + 1 - orbit)) {
							break;
						}
						++rv;
						System.out.println(str.substring(i - orbit, i + orbit + 1));
					} else {
						break;
					}
				}
			}
		}

		for (float i = (float) 0.5; i < str.length(); ++i) {
			for (float orbit = (float) 0.5; orbit <= str.length() / 2; ++orbit) {
				if (i + orbit >= str.length() || i - orbit < 0) {
					break;
				} else {
					if (str.charAt((int) (i + orbit)) == str.charAt((int) (i - orbit))
							&& str.charAt((int) (i)) == str.charAt((int) (i - orbit))) {
						++rv;
						System.out.println(str.substring((int) (i - orbit), (int) (i + orbit + 1)));
					} else {
						break;
					}
				}
			}
		}

		return rv;
	}

}
