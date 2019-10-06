
public class numDecodings {
	public int numDecodings(String s) {
		char[] carr = s.toCharArray();
		int[] arr = new int[s.length() + 1];

		if (carr[0] == '0')
			return 0;

		arr[0] = arr[1] = 1;

		for (int i = 2; i < arr.length; ++i) {
			if (carr[i - 1] != '0')
				arr[i] = arr[i - 1];

			if (carr[i - 2] == '1' || carr[i - 2] == '2' && carr[i - 1] < '7') {
				arr[i] += arr[i - 2];
			}
		}
		return arr[arr.length - 1];
	}

	public int numDecodings2(String s) {
		int mod = 1000000007;
		char[] carr = s.toCharArray();
		int[] arr = new int[s.length() + 1];

		arr[0] = 1;
		if (carr[0] == '0')
			return 0;
		else if (carr[0] == '*')
			arr[1] = 9;
		else
			arr[1] = 1;

		for (int i = 2; i < arr.length; ++i) {
			if (carr[i - 1] == 0) {
				arr[i] = 0;
			} else if (carr[i - 1] == '*') {
				arr[i] = (arr[i] * 10) % mod;
			} else {
				arr[i] = arr[i - 1];
			}

			if (carr[i - 2] == '1' || carr[i - 2] == '*') {
				if (carr[i - 1] == '*')
					arr[i] += (arr[i - 2] * 10) % mod;
				else
					arr[i] = (arr[i] + arr[i - 2]) % mod;
			} else if (carr[i - 2] == '2') {
				if (carr[i - 1] == '*')
					arr[i] += arr[i - 2] * 6 % mod;
				else
					arr[i] = (arr[i] + arr[i - 2]) % mod;
			}
		}
		return arr[arr.length - 1];
	}

	public static void main(String[] args) {
		char ch = '*';
		System.out.println((int) ch);
	}
}
