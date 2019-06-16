
public class stringDecodeFindChar {

	public static boolean isChar(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		else
			return false;
	}

	public static void find(String str, int size, int k) {
		int i = str.length();
		while (i > 0) {
			k = (k + 1) % size;
			char ch = str.charAt(i);
			if (!isChar(ch)) {
				size = size / Integer.parseInt(ch + "");
			} else {
				size--;
			}
			k = k % size;
			--i;
		}
		System.out.println(str.charAt(size - 1));
	}

	public static void main(String[] args) {
//		System.out.println(find("a3b2c2xy", 17, 11));
		find("a3b2c2xy", 17, 11);
	}

}
