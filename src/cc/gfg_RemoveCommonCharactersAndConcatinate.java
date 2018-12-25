package cc;

import java.util.HashMap;
import java.util.Scanner;

public class gfg_RemoveCommonCharactersAndConcatinate {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		scan.nextLine();

		while (t > 0) {
			--t;

			String str1 = scan.nextLine();
			String str2 = scan.nextLine();

			HashMap<Character, Boolean> stemp2 = new HashMap<>();

			for (int i = 0; i < str2.length(); ++i) {
				stemp2.put(str2.charAt(i), true);
			}

			char ch;

			for (int i = 0; i < str1.length(); ++i) {
				ch = str1.charAt(i);
				if (stemp2.containsKey(ch)) {
					str1 = str1.replace(ch, ' ');
					str2 = str2.replace(ch, ' ');
				}

			}
			str1 = str1.trim() + str2.trim();

			boolean f = false;

			for (int i = 0; i < str1.length(); ++i) {
				if (str1.charAt(i) != ' ') {
					f = true;
					System.out.print(str1.charAt(i));
				}
			}
			if (!f)
				System.out.print("-1");
			System.out.println();

		}

		scan.close();
	}

}
