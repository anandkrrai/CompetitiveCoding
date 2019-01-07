package cc;

import java.util.Scanner;

public class hackerEarth_sevenSegmentDisplay {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		scan.nextLine();

		while (t-- > 0) {
			String str = scan.nextLine();
			int line = 0;
			for (int i = 0; i < str.length(); ++i) {
				char ch = str.charAt(i);
				switch (ch) {
				case '0': {
					line += 6;
					break;
				}
				case '1': {
					line += 2;
					break;
				}
				case '2': {
					line += 5;
					break;
				}
				case '3': {
					line += 5;
					break;
				}
				case '4': {
					line += 4;
					break;
				}
				case '5': {
					line += 5;
					break;
				}
				case '6': {
					line += 6;
					break;
				}
				case '7': {
					line += 3;
					break;
				}
				case '8': {
					line += 7;
					break;
				}
				case '9': {
					line += 6;
					break;
				}
				}
			}
			if (line % 2 == 0) {
				for (int i = 0; i < line / 2; ++i) {
					System.out.print("1");
				}
			} else {
				System.out.print("7");
				for (int i = 0; i < (line - 3) / 2; ++i) {
					System.out.print("1");
				}
			}
			System.out.println("");

		}

	}
}
