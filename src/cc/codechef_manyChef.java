package cc;

import java.util.Scanner;

//https://www.codechef.com/problems/MANYCHEF
public class codechef_manyChef {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
//?=63
		int t = scan.nextInt();
		scan.nextLine();

		while (t-- > 0) {
			
			String str = scan.nextLine();
			for (int i = 0; i <=str.length() - 4; ++i) {
				if (str.charAt(i) == '?' || str.charAt(i) == 'C') {
					if (str.charAt(i + 1) == '?' || str.charAt(i + 1) == 'H') {
						if (str.charAt(i + 2) == '?' || str.charAt(i + 2) == 'E') {
							if (str.charAt(i + 3) == '?' || str.charAt(i + 3) == 'F') {
								str = str.substring(0, i) + "CHEF" + str.substring(i + 4);
								i += 3;
							}
						}
					}
				}
			}
			str = str.replace('?', 'A');
			System.out.println(str);
		}

		scan.close();
	}

}
