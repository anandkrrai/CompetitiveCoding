package arraysAndstrings;

import java.util.Scanner;

public class shiftingLetters {

	public static String shiftingLetters(String S, int[] shifts) {

		for (int i = shifts.length - 2; i >= 0; --i) {
			shifts[i] = (shifts[i] % 26 + shifts[i + 1]) % 26;
		}

		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < shifts.length; ++i) {
			char ch = S.charAt(i);
			int shift = shifts[i] + (int) (ch - 'a');
			shift %= 26;
			ch = (char) ('a' + shift);
			sb.append(ch);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		int N = sc.nextInt();

		int[] shifts = new int[N];

		for (int i = 0; i < N; i++) {
			shifts[i] = sc.nextInt();
		}

		System.out.println(shiftingLetters(S, shifts));
	}
}