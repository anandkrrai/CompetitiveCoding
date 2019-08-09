package hh;

public class InterestingNumber {

	public static long[] bank;

	private static void fillArr() {
		bank = new long[19];
		bank[1] = 4;
		bank[2] = 25L;
		for (int i = 4; i < 19; i += 2) {
			bank[i] = bank[i - 2] * 25;
		}
		int count = 2;
		for (int i = 3; i < 19; i += 2) {
			bank[i] = count * 4 * bank[i - 1];
			++count;
		}
	}

	public static void main(String[] args) {
		fillArr();
		for (long val : bank)
			System.out.println(val);
	}

}
