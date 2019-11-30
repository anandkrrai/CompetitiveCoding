package mathematics;

public class mod {
	static int mod(String num, int a) {

		// Initialize result
		int res = 0;

		// One by one process all digits of 'num'
		for (int i = 0; i < num.length(); i++)
			res = (res * 10 + ((int) num.charAt(i) - '0')) % a;

		return res;
	}
	public static void main(String[] args) {
		System.out.println(mod("131",11));
	}
}
