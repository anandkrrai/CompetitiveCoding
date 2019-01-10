package cc;

public class palindrome {

	public static void main(String[] args) {
		String str = "annad";
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {

		int length = str.length();
		int i = 0;

		for (i = 0; i < length; ++i) {
			for (int j = 0; j <= length / 2; ++j) {
				if (i - j >= 0 && i + j < length) {
					if (str.charAt(i - j) == str.charAt(i + j)) {
						System.out.println(str.substring(i - j, i + j + 1));
					}
				}
			}
		}

		for (float k = (float) 0.5; k < str.length(); ++k) {
			for (float j = (float) 0.5; j <= length / 2; ++j) {
				if (k - j >= 0 && k + j < length) {

					if (str.charAt((int) (k - j)) == str.charAt((int) (k + j))) {
						System.out.print(str.substring((int) (k - j), (int) (k + j + 1)));
					}
				}
			}
		}

		return false;
	}

}
