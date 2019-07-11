package misc;

public class BinaryGap {
	public static int binaryGap(int N) {
		String str = Integer.toBinaryString(N);
		int rv = 0, i = -1, j = 0;

		while (j < str.length()) {
			if (str.charAt(j) == '1') {
				if (i != -1)
					rv = Math.max(rv, j - i);
				i = j;
			}
			++j;
		}

		return rv;
	}

	public static void main(String[] args) {
		System.out.println(binaryGap(4));
	}

}
