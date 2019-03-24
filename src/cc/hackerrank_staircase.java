package cc;

public class hackerrank_staircase {
	
	
	
	static int stepPerms(int n) {
		int[] arr = new int[n + 1];

		int mod =  1000000007;
		arr[0] = 1;
		for (int i = 1; i <= n; ++i) {
			if (i < 3) {
				arr[i] = i;
			} else {
				arr[i] = (arr[i - 1] % mod + arr[i - 2] % mod + arr[i - 3] % mod) % mod;
			}
		}
		return arr[n];
	}

	public static void main(String[] args) {

	System.out.println(stepPerms(33));
	}

}
