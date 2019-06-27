package arraysAndstrings;

import java.util.Scanner;

public class plusOne {
	public static int[] plusOne(int[] digits) {
		int carry = 0;
		int[] arr = new int[digits.length+1];

		for (int i = digits.length; i > 0; --i) {
			arr[i] = digits[i - 1] + carry;
			carry = arr[i] / 10;
		}
		arr[0] = carry;
		if (carry != 0)
			return arr;
		else {
			int[] rv = new int[digits.length];
			for (int i = 0; i < digits.length; ++i) {
				rv[i] = arr[i + 1];
			}
			return rv;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] Input = new int[n];
		for (int i = 0; i < Input.length; i++) {
			Input[i] = scn.nextInt();
		}
		int ans[] = plusOne(Input);
		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

}
