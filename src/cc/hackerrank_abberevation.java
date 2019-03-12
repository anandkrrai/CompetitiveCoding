package cc;

import java.util.Scanner;

public class hackerrank_abberevation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();

		while (t-- > 0) {
			String str1 = scanner.nextLine();
			String str2 = scanner.nextLine();
			int i=0,j=0;
			
			for(j=0;j<str2.length();++j) {
				if(str1.charAt(i)==str2.charAt(j)) {
					++i;
					
				}else {
					if(str1.charAt(i)>='A') {
						System.out.println("NO");
						break;
					}else {
						++i;
					}
				}
			}
			while(i<str2.length()) {
				if(str2.charAt(i)>='A') {
					break;
				}
			}
		}
	}

}
