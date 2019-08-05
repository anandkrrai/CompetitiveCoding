package dp;

import java.util.Arrays;

public class countSetBits {
	public static int[] countBits(int num) {
		int[] rv = new int[num + 1];

		for (int n = 0; n <= num; ++n) {
			rv[n]=countSetBits(n);
		}
		return rv;
	}

	static int countSetBits(int n) {
		int count = 0;
		while (n > 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = countBits(2);
		System.out.println(Arrays.toString(arr));
//		System.out.println(countSetBits(5));
	}
}
