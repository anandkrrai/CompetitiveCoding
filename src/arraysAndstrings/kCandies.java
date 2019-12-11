package arraysAndstrings;

import java.util.*;

public class kCandies {

	public static void main(String args[]) throws Exception {

		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());

		while (t-- > 0) {
			String[] arr = scan.nextLine().trim().split("\\s+");
			String str = scan.nextLine().toLowerCase();
			System.out.println(str);
			System.out.println(find(str, Integer.parseInt(arr[1])));
		}
	}

	public static int find(String str, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, rv = 0;

		while (j < str.length()) {

			if (map.size() > k) {
				if (isVowel(str.charAt(i))) {
					if (map.get(str.charAt(i)) == 1) {
						map.remove(str.charAt(i));
					} else {
						map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
					}
				}
				i++;
			} else {
				if (isVowel(str.charAt(j))) {
					map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
				}
				++j;
			}
			
			if (map.size() == k)
				rv = Math.max(rv, j - i );

		}

		return rv;
	}

	public static boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		} else {
			return false;
		}
	}

}
