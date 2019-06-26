package map_set;

import java.util.*;

public class equalNoOfZeroAndOne {

	public static void print(char[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0, ans = 0;
		for (int i = 0; i < A.length; ++i) {
			char ch = A[i];

			if (ch == '1') {
				sum++;
			} else {
				sum--;
			}

			if (map.containsKey(sum)) {
				ans = Math.max(ans, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.next();
		char[] ans = str.toCharArray();
		print(ans);
	}

}
