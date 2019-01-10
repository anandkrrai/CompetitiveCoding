package cc;

import java.util.Scanner;

public class goodstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();

		int maxLen = 0, count = 0;

	
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			switch (ch) {
			case 'a': {
				++count;
				break;
			}
			case 'e': {
				++count;
				break;
			}
			case 'i': {
				++count;
				break;
			}
			case 'o': {
				++count;
				break;
			}
			case 'u': {
				++count;
				break;
			}
			default: {
				if (count > maxLen) {
					maxLen = count;
					count = 0;
				}
			}
			}
		}
		if (count > maxLen) {
			maxLen = count;
		}
		System.out.println(maxLen);

	}
}
