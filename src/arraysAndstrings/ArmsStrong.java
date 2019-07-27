package arraysAndstrings;

public class ArmsStrong {
	public static boolean isArmstrong(int N) {
		String str = N + "";
		int digits = str.length();
		int temp = N, ans = 0;

		while (temp > 0) {
			ans += Math.pow(temp % 10, digits);
			temp /= 10;
		}

		if (ans == N)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(isArmstrong(153));
	}

}
