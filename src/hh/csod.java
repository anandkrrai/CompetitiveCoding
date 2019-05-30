package hh;

import java.util.*;

public class csod {

	public static long answer(String numberToBeDisplayed) {
		int[] hor = { 2, 0, 3, 3, 1, 3, 3, 1, 3, 3 };
		int[] ver = { 4, 2, 2, 2, 3, 2, 3, 3, 4, 3 };
		long v = 0, h = 0;

		for (int i = 0; i < numberToBeDisplayed.length(); ++i) {
			h += hor[numberToBeDisplayed.charAt(i) - 48];
			v += ver[numberToBeDisplayed.codePointAt(i) - 48];
		}

		return v - h;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(answer("4000"));
		scan.close();
	}

}
