package cc;

import java.util.Scanner;

public class hackerearth_shiftLetters {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String str = s.nextLine();
		int t = s.nextInt();
		int[] arr = new int[str.length() - 1];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = Math.abs(str.charAt(i) - str.charAt(i + 1));
		}
	}

}
