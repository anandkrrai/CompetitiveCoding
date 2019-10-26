
public class AlternateBits {
	public boolean hasAlternatingBits(int n) {
		return (n & (n << 1)) == 0;
	}
}
