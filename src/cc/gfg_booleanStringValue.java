package cc;

import java.util.Scanner;

public class gfg_booleanStringValue {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		while (t > 0) {
			--t;

			String st = scan.nextLine();
			
			
			

			int ans = Integer.parseInt(st.charAt(0) + "");
			char ch;
			for (int i = 1; i < st.length(); i += 2) {
				ch = st.charAt(i);

				switch (ch) {
				case 'A': {
					ans = ans & Integer.parseInt( st.charAt(i + 1)+"");
					break;

				}
				case 'B': {
					ans = ans | Integer.parseInt( st.charAt(i + 1)+"");

					break;

				}
				case 'C': {
					ans = ans ^ Integer.parseInt( st.charAt(i + 1)+"");

					break;

				}

				}

			}
			System.out.println((int)ans);
		}
		scan.close();
	}

}