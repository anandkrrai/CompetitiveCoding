package cc;

public class nonRepeatingCharacter {

	public static void main(String[] args) {
System.out.println(strWithout3a3b(4, 1));
	}

	public static String strWithout3a3b(int a, int b) {
		StringBuilder str = new StringBuilder("");

//		if (a > b) {
//			str.append('a');
//			--a;
//		} else {
//			str.append('b');
//			--b;
//		}
//		if (a > b) {
//			str.append('a');
//			--a;
//		} else {
//			str.append('b');
//			--b;
//		}

		while (a != 0 || b != 0) {
			if (a > b) {
				if (str.length() >= 2 && str.charAt(str.length() - 1) == 'a' && str.charAt(str.length() - 2) == 'a') {
					str.append('b');
					--b;
				} else {
					str.append('a');
					--a;
				}
			} else {
				if (str.length() >= 2 && str.charAt(str.length() - 1) == 'b' && str.charAt(str.length() - 2) == 'b') {
					str.append('a');
					--a;
				} else {
					str.append('b');
					--b;
				}
			}
		}

		return str.toString();
	}

}
