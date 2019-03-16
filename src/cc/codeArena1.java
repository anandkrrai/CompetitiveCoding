package cc;

import java.util.HashSet;
import java.util.Scanner;

public class codeArena1 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		scan.nextLine();

		while (t-- > 0) {
			String str = scan.nextLine();

			HashSet<String> set = new HashSet<String>();

			for (int i = 0; i < str.length(); ++i) {
				for (int j = i; j < str.length(); ++j) {
					set.add(str.substring(i,j));
				}
			}
			System.out.println(set.size());
		}

		scan.close();

	}
}
