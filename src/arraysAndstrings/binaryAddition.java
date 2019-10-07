package arraysAndstrings;

public class binaryAddition {
	public int convert(String str) {
		int rv = 0, num;
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if (ch == '1') {
				num = 1;
			} else {
				num = 0;
			}
			rv = rv * 2 + num;
		}
		return rv;
	}

	public String addBinary(String a, String b) {
        int an = convert(a);
        int bn = convert(b);
        
        return Integer.toBinaryString(an+bn);
    }

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(i));
	}

}
