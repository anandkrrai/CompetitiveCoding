package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class codesule_spectralValue {

	public static int power(int x, int y) {
		if (y == 0) {
			return 1;
		}
		if (y == 1) {
			return x;
		} else {
			int rv = power(x, y / 2);
			rv = (rv % mod) * (rv % mod);
			if (y % 2 == 1)
				rv = rv * (x % mod);
			return rv % mod;
		}
	}

	public static int exponentMod(int A, int B, int C) {
		if (A == 0)
			return 0;
		if (B == 0)
			return 1;
		// If B is even
		long y;
		if (B % 2 == 0) {
			y = exponentMod(A, B / 2, C);
			y = (y * y) % C;
		}
		// If B is odd
		else {
			y = A % C;
			y = (y * exponentMod(A, B - 1, C) % C) % C;
		}

//		return (int) ((y + C) % C);
		return (int) y;
	}

	public static int mod = 1000000007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < m; ++i) {
			int opt = sc.nextInt();

			if (opt == 1) {
				int j = sc.nextInt();
				int x = sc.nextInt();
				arr[j - 1] = x;
			} else {
				int y = sc.nextInt();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int k = 0; k < y; ++k) {

					if (!map.containsKey(arr[k])) {
						map.put(arr[k], 1);
					} else {
						map.put(arr[k], map.get(arr[k]) + 1);
					}
				}

				ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());

				int ans = 1;
				for (Integer num : list) {
					int pow = map.get(num);
					ans = ((ans % mod) * exponentMod(pow + 1, pow + 1, mod) % mod);
				}

				System.out.println(ans);
			}

		}

	}

}
