package cc;

import java.util.*;

public class hackerearth_monk_andKundan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		scan.nextLine();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String s = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0; i < s.length(); ++i) {
			map.put(s.charAt(i), i);
		}

		while (t-- > 0) {
			String[] arr = scan.nextLine().trim().split("\\s+");
			int sum = 0;
			for (String st : arr) {
				for (int i = 0; i < st.length(); ++i) {
					sum += i + map.get(st.charAt(i));
				}
			}
			System.out.println(sum * arr.length);
		}

		scan.close();
	}

}
