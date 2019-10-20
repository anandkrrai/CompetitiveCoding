
public class ReverseBits {
	public int reverseBits(int n) {
		StringBuilder sb = new StringBuilder("");
		sb.append(Integer.toBinaryString(n));
		sb.reverse();
		long rv = 0;
		for (int i = 0; i < sb.length(); ++i)
			rv = rv * 2 + (sb.charAt(i) - '0');
		return (int)rv;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
